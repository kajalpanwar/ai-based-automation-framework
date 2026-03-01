package com.automation.framework.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Central configuration management.
 * Loads properties from config files and environment variables.
 */
public final class Config {

    private static final String CONFIG_FILE = "config/application.properties";
    private static Properties properties;

    static {
        loadProperties();
    }

    private Config() {
    }

    private static void loadProperties() {
        properties = new Properties();
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input != null) {
                properties.load(input);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration: " + e.getMessage());
        }
    }

    public static String getBaseUrl() {
        return getProperty("api.base.url", "https://jsonplaceholder.typicode.com");
    }

    public static int getConnectionTimeout() {
        return Integer.parseInt(getProperty("api.connection.timeout", "5000"));
    }

    public static int getReadTimeout() {
        return Integer.parseInt(getProperty("api.read.timeout", "10000"));
    }

    public static String getProperty(String key, String defaultValue) {
        String envKey = key.toUpperCase().replace(".", "_");
        String envValue = System.getenv(envKey);
        if (envValue != null) {
            return envValue;
        }
        return properties.getProperty(key, defaultValue);
    }

    public static String getProperty(String key) {
        return getProperty(key, null);
    }
}
