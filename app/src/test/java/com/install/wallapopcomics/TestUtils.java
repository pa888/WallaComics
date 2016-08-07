package com.install.wallapopcomics;

/**
 * Created by Peter on 07.08.2016.
 */
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * Class Utils, contains helper methods local unit tests
 */
public class TestUtils {
    private final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

    /**
     * Print log to terminal
     *
     * @param log - text to print
     */
    public void log(String log) {
        System.out.println(log);
    }

    /**
     * Read file with json from test resources, and return it as specified object
     *
     * @param fileName Url of file with json
     * @param inClass Class of T
     * @param <T> Type of the desired object
     * @return Object created from json
     */
    public <T> T readJson(String fileName, Class<T> inClass) {
        return gson.fromJson(readString(fileName), inClass);
    }

    /**
     * Read file with json from test resources, and return it as specified object
     *
     * @param fileName Url of file with json
     * @param inClass Specific generalized type
     * @param <T> Type of the desired object
     * @return Object created from json
     */
    public <T> T readJson(String fileName, Type inClass) {
        return gson.fromJson(readString(fileName), inClass);
    }

    /**
     * Read file with json from test resources, and return it as String
     *
     * @param fileName Url of file with json
     * @return String created from json
     */
    public String readString(String fileName) {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(fileName);
        try {
            int size = stream.available();
            byte[] buffer = new byte[size];
            //noinspection ResultOfMethodCallIgnored
            stream.read(buffer);
            return new String(buffer, "utf8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}