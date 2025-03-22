package org.vaadin.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class Utility {


    public  static <T> T loadJson(String filename, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream("json/" + filename)) {
            return objectMapper.readValue(inputStream, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
