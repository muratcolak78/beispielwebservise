package com.allcompare.bingoastradirectwebservice.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Field;


@Slf4j
public class JsonUtil {

    private static final String JSON_IS_BLANK = "Json is blank";

    /**
     * A private constructor is used to hide the public constructor since method calls are static.
     */
    private JsonUtil() {

    }

    public static <T> T parseJsonToObject(String json, Class<T> clazz) {

        if (clazz == null) {
            log.error("Clazz is null");
            return null;
        }
        if (StringUtils.isBlank(json)) {
            log.error(JSON_IS_BLANK);
            return null;
        }

        T obj = null;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            obj = objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            log.error("ParsingException", e);
        }
        return obj;
    }

    public static String parseObjectToJson(Object object) {
        if (object == null) {
            log.error("Object is null");
            return null;
        }

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Exception while parsing, returning null", e);
        }
        return null;
    }
}
