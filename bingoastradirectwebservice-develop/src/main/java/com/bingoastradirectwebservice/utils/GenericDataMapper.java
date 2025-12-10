package com.allcompare.bingoastradirectwebservice.utils;

import com.allcompare.bingoastradirectwebservice.annotation.FormElement;
import com.allcompare.bingoastradirectwebservice.model.PriceRequest;
import jakarta.xml.bind.DataBindingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;


@Slf4j
public class GenericDataMapper {

    private GenericDataMapper() {

    }

    // Map<String, Object> (Contract JSON) → ContractValue
    public static <T> T mapFromPayload(Map<String, Object> payload, Class<T> targetClass) {
        if (payload == null || payload.isEmpty()) {
            log.warn("Payload empty for class: {}", targetClass.getSimpleName());
            return createEmptyInstance(targetClass);
        }

        return mapWithDataSource(
                questionName -> findByQuestionName(payload, questionName)
                        .map(GenericDataMapper::getStringValue)
                        .orElse(""),
                targetClass
        );
    }

    // PriceRequest (questionList) → ContractValue
    public static <T> T mapFromPriceRequest(PriceRequest priceRequest, Class<T> targetClass) {
        if (priceRequest == null) {
            log.warn("PriceRequest is null for class: {}", targetClass.getSimpleName());
            return createEmptyInstance(targetClass);
        }

        return mapWithDataSource(
                questionName -> ContractDataUtil.getValue(priceRequest, questionName),
                targetClass
        );
    }

    // Generic mapping core logic
    private static <T> T mapWithDataSource(Function<String, String> valueExtractor, Class<T> targetClass) {
        try {
            T instance = createEmptyInstance(targetClass);
            Field[] fields = targetClass.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                if (!field.isAnnotationPresent(FormElement.class)) continue;

                FormElement annotation = field.getAnnotation(FormElement.class);
                String questionName = annotation.questionName();

                if (StringUtils.isBlank(questionName)) continue;

                String value = valueExtractor.apply(questionName);

                if (field.getType() == String.class && StringUtils.isNotBlank(value)) {
                    field.set(instance, value);
                    log.debug("Mapped {}.{}: {} = {}", targetClass.getSimpleName(), field.getName(), questionName, value);
                }
            }

            return instance;
        } catch (Exception e) {
            log.error("Error mapping to {}: {}", targetClass.getSimpleName(), e.getMessage(), e);
            throw new DataBindingException("Data binding error for " + targetClass.getSimpleName(), e);
        }
    }


    private static <T> T createEmptyInstance(Class<T> targetClass) {
        try {
            return targetClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Cannot create instance of " + targetClass.getName(), e);
        }
    }

    private static Optional<Object> findByQuestionName(Map<String, Object> payload, String questionName) {
        if (payload.containsKey(questionName)) {
            return Optional.ofNullable(payload.get(questionName));
        }

        for (Object v : payload.values()) {
            if (v instanceof Map) {
                Map<String, Object> m = (Map<String, Object>) v;
                if (questionName.equals(m.get("name"))) {
                    return Optional.of(m);
                }
            } else if (v instanceof Iterable) {
                for (Object item : (Iterable<?>) v) {
                    if (item instanceof Map) {
                        Map<String, Object> m = (Map<String, Object>) item;
                        if (questionName.equals(m.get("name"))) {
                            return Optional.of(m);
                        }
                    }
                }
            }
        }
        return Optional.empty();
    }

    private static String getStringValue(Object raw) {
        if (raw == null) return "";
        if (raw instanceof Map) {
            Map<?, ?> m = (Map<?, ?>) raw;
            Object rv = m.get("returnValue");
            return rv != null ? String.valueOf(rv) : "";
        }
        return String.valueOf(raw);
    }
}