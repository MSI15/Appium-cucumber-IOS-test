package utils;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

public class Settings {
    public static final String applicationPath;
    public static final String device;
 
    static {
        // Read properties file.
        Properties properties = new Properties();
        try {
            ClassPathResource res = new ClassPathResource("environment.properties");
            properties.load(res.getInputStream());
            properties.putAll(System.getProperties());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        applicationPath = properties.getProperty("applicationPath");
        device = properties.getProperty("device");
    }
}