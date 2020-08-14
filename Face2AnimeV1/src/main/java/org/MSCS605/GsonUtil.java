package org.MSCS605;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Map;

public class GsonUtil {
    private static Gson gson = new GsonBuilder().create();

    public static String toJson(Object value) {
        return gson.toJson(value);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonParseException {
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type typeOfT) throws JsonParseException {
        return (T) gson.fromJson(json, typeOfT);
    }

    public static Map convertJSONToMap(String json_string) throws Exception {

        try {
            Gson gson = new Gson();
            Map output_map = gson.fromJson(json_string, Map.class);
            System.out.println("Task complete: Convert JSON to Map: " + output_map);
            return output_map;
        } catch (Exception e){
            System.out.println("Failed in converting JSON to Map!");
            throw e;
        }
    }
}
