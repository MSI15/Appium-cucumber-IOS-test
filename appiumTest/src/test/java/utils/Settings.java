package utils;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

public class Settings {
    public static final String applicationPath;
    public static final String device;
    public static final String applicationPackage;
    public static final String launchActivity;
    public static final String emulatorVersion;
    public static final String androidEmulator;
    public static final String bundleID;
    public static final String udid;
    public static final String iOSDevice;
    public static final String iOSversion;
   
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
        applicationPackage = properties.getProperty("applicationPackage");
        launchActivity = properties.getProperty("launchActivity");
        emulatorVersion = properties.getProperty("emulatorVersion");
        androidEmulator = properties.getProperty("AndroidEmulator");
        bundleID = properties.getProperty("bundleID");
        udid = properties.getProperty("UDID");
        iOSDevice = properties.getProperty("iOSDevice");
        iOSversion = properties.getProperty("iOSVersion");
    }
}