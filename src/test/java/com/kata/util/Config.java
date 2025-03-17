package com.kata.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Logger log = LoggerFactory.getLogger(Config.class);
    private static final String DEFAULT_PROPERTIES = "config/default.properties";
    private static Properties properties;

    public static void Initialize() {
        properties = loadProperties();
        for (String key : properties.stringPropertyNames()) {
            // Check if the system property is set and update it in properties
            String systemValue = System.getProperty(key);
            if (systemValue != null) {
                properties.setProperty(key, systemValue);
            }
        }

        log.info("Test Properties");
        for (String key : properties.stringPropertyNames()) {
            log.info("{}={}", key, properties.getProperty(key));
        }
    }


    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream stream = ResourceLoader.getResource(DEFAULT_PROPERTIES)) {
            properties.load(stream);
        } catch (Exception e) {
            log.error("Unable to read property file {}", DEFAULT_PROPERTIES, e);
        }
        return properties;
    }
}