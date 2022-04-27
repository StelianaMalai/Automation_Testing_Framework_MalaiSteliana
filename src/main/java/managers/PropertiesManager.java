package managers;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private static Properties testingProperties;
    private static String pathToProperties = "src/main/resources/configuration.properties";

    public static void initializeProperties() {
        testingProperties = new Properties();
        try {
            testingProperties.load(new FileReader(pathToProperties));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static String getBrowserType() {
        if (testingProperties == null) initializeProperties();
        String collectedBrowserType = testingProperties.getProperty("browserType");
        if (collectedBrowserType != null) {
            return collectedBrowserType;
        } else {
            throw new RuntimeException("The browser type is not defined in configuration file. Please check this");
        }
    }
    public static String getBaseUrl() {
        if (testingProperties == null) initializeProperties();
        String collectedBaseUrl = testingProperties.getProperty("baseURL");
        if (collectedBaseUrl != null) {
            return collectedBaseUrl;
        } else {
            throw new RuntimeException("The base URL is not defined in configuration file. Please check this");
        }
    }

    }