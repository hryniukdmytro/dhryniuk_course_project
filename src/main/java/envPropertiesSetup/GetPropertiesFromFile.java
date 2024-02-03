package envPropertiesSetup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.util.Objects.isNull;

public class GetPropertiesFromFile {
    public static final String PATH_TO_RESOURCE = "src/test/resources/properties/";
    public static final String ENV_PROPERTIES_FILE_NAME = "env.properties";
    public static final String TESTDATA_PROPERTIES_FILE_NAME = "testData.properties";

    public static String propertyValue(String pathToFile, String propertyFileName, String propertyName) {
        String systemProperty = System.getProperty(propertyName);
        return !isNull(systemProperty) ? systemProperty : getPropertyValue(pathToFile, propertyFileName, propertyName);
    }

    protected static String getPropertyValue(String pathToFile, String fileName, String propertyName) {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(pathToFile + fileName)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(propertyName);
    }
}
