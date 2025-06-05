package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configManager {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream input = new FileInputStream("src/test/resources/env/config.properties");
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage());
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Key not found in config: " + key);
        }
        return value;
    }
}
