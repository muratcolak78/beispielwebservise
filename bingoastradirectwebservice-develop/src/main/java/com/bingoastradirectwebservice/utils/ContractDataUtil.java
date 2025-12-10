package com.allcompare.bingoastradirectwebservice.utils;

import com.allcompare.bingoastradirectwebservice.model.PriceRequest;
import com.allcompare.bingoastradirectwebservice.model.Question;

import java.util.Map;

public class ContractDataUtil {

    /**
     * A private constructor is used to hide the public constructor since method calls are static.
     */
    private ContractDataUtil() {

    }

    public static String getValue(Object source, String key) {

        if (source instanceof PriceRequest priceRequest) {
            return priceRequest.getQuestionList()
                    .stream()
                    .filter(question -> key.equals(question.getName()))
                    .findFirst()
                    .map(Question::getReturnValue)
                    .orElse(null);
        } else if (source instanceof Map) {
            Map<String, Object> dataMap = (Map<String, Object>) source;
            return dataMap.entrySet()
                    .stream()
                    .filter(entry -> isMatchingQuestion(entry, key))
                    .findFirst()
                    .map(entry -> ((Map<String, String>) entry.getValue()).get("returnValue"))
                    .orElse(null);
        }

        throw new IllegalArgumentException("Unsupported data source type: " +
                (source != null ? source.getClass().getName() : "null"));

    }

    private static boolean isMatchingQuestion(Map.Entry<String, Object> entry, String questionKey) {
        Object value = entry.getValue();
        if (value instanceof Map) {
            Map<String, Object> question = (Map<String, Object>) value;
            return question.containsKey("name") && question.get("name").equals(questionKey);
        }
        return false;
    }
}