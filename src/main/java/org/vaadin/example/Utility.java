package org.vaadin.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class Utility {


    public  static <T> T loadJson(String filename, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        objectMapper.registerModule(new JavaTimeModule());

        try (InputStream inputStream = classLoader.getResourceAsStream("json/" + filename)) {
            return objectMapper.readValue(inputStream, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static <T> T loadJson2(String filename, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("json/" + filename);

        if (inputStream == null) {
            throw new RuntimeException("File not found: " + filename);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            // Converte lo stream in una stringa (alternativa a readAllBytes)
            String jsonContent = reader.lines().collect(Collectors.joining("\n"));
            return objectMapper.readValue(jsonContent, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Errore nella lettura del JSON", e);
        }
    }

}
