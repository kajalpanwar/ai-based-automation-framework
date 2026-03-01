package com.automation.framework.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * JSON serialization/deserialization utilities.
 */
public final class JsonUtils {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private JsonUtils() {
    }

    public static String toJson(Object obj) {
        return GSON.toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return GSON.fromJson(json, clazz);
    }

    public static Gson getGson() {
        return GSON;
    }
}
