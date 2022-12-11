package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesCache {

    Logger logger = Logger.getLogger(this.getClass().getName());
    private final Properties properties = new Properties();

    private PropertiesCache() {
        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(in);
        } catch (IOException exception) {
            logger.warning(exception.getMessage());
        }
    }

    private static class LazyHolder {
        private static final PropertiesCache INSTANCE = new PropertiesCache();
    }

    public static PropertiesCache getInstance()
    {
        return LazyHolder.INSTANCE;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}