package course_project.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.util.Objects.isNull;

public class EnvPropertiesSetup {
    public static final String PATH_TO_RESOURCE = "src/test/resources/properties/";
    public static final String ENV_PROPERTIES_FILE_NAME = "env.properties";
    public static final String TESTDATA_PROPERTIES_FILE_NAME = "testData.properties";
    public static String API_URL;
    public static String BASE_URL;
    public static String API_USERNAME;
    public static String API_TOKEN;
    public static String COOKIE_NAME;
    public static String COOKIE_VALUE;
    public static String TESTDATA_PROJECT_NAME;
    public static String TESTDATA_PROJECT_NAME_1;
    public static String TESTDATA_PROJECT_NAME_2;
    public static String TESTDATA_TASK_TITLE;
    public static String TESTDATA_SUBTASK_TITLE;
    public static String TESTDATA_COMMENT_TEXT;
    public static String TESTDATA_LOGIN;
    public static String TESTDATA_PASSWORD;
    public static String TESTDATA_NEW_USER_NAME;
    public static String TESTDATA_NEW_USER_PASSWORD;

    public static void authConstantsSetup() {
        API_URL = propertyValue(PATH_TO_RESOURCE, ENV_PROPERTIES_FILE_NAME, "apiURL");
        BASE_URL = propertyValue(PATH_TO_RESOURCE, ENV_PROPERTIES_FILE_NAME, "baseURL");
        API_USERNAME = propertyValue(PATH_TO_RESOURCE, ENV_PROPERTIES_FILE_NAME, "username");
        API_TOKEN = propertyValue(PATH_TO_RESOURCE, ENV_PROPERTIES_FILE_NAME, "token");
    }

    public static void cookieConstantsSetup() {
        COOKIE_NAME = propertyValue(PATH_TO_RESOURCE, ENV_PROPERTIES_FILE_NAME, "cookieName");
        COOKIE_VALUE = propertyValue(PATH_TO_RESOURCE, ENV_PROPERTIES_FILE_NAME, "cookieValue");
    }

    public static void testDataConstantsSetup() {
        TESTDATA_PROJECT_NAME = propertyValue(PATH_TO_RESOURCE, TESTDATA_PROPERTIES_FILE_NAME, "projectTitle");
        TESTDATA_PROJECT_NAME_1 = propertyValue(PATH_TO_RESOURCE, TESTDATA_PROPERTIES_FILE_NAME, "projectTitle1");
        TESTDATA_PROJECT_NAME_2 = propertyValue(PATH_TO_RESOURCE, TESTDATA_PROPERTIES_FILE_NAME, "projectTitle2");
        TESTDATA_TASK_TITLE = propertyValue(PATH_TO_RESOURCE, TESTDATA_PROPERTIES_FILE_NAME, "taskTitle");
        TESTDATA_SUBTASK_TITLE = propertyValue(PATH_TO_RESOURCE, TESTDATA_PROPERTIES_FILE_NAME, "subTaskTitle");
        TESTDATA_COMMENT_TEXT = propertyValue(PATH_TO_RESOURCE, TESTDATA_PROPERTIES_FILE_NAME, "comment");
        TESTDATA_LOGIN = propertyValue(PATH_TO_RESOURCE, TESTDATA_PROPERTIES_FILE_NAME, "login");
        TESTDATA_PASSWORD = propertyValue(PATH_TO_RESOURCE, TESTDATA_PROPERTIES_FILE_NAME, "password");
        TESTDATA_NEW_USER_NAME = propertyValue(PATH_TO_RESOURCE, TESTDATA_PROPERTIES_FILE_NAME, "newUserName");
        TESTDATA_NEW_USER_PASSWORD = propertyValue(PATH_TO_RESOURCE, TESTDATA_PROPERTIES_FILE_NAME, "newUserPassword");

    }

    public static String propertyValue(String pathToFile, String propertyFileName, String propertyName) {
        String systemProperty = System.getProperty(propertyName);
        return !isNull(systemProperty) ? systemProperty : getPropertyValue(pathToFile, propertyFileName, propertyName);
    }

    private static String getPropertyValue(String pathToFile, String fileName, String propertyName) {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(pathToFile + fileName)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(propertyName);
    }
}
