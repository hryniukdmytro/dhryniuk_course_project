package course_project.envPropertiesSetup;

import static course_project.envPropertiesSetup.GetPropertiesFromFile.*;

public class EnvAuthAndCookiesSetup {
    public static String API_URL;
    public static String API_URL_SUFFIX;
    public static String BASE_URL;
    public static String API_USERNAME;
    public static String API_TOKEN;

    public static void authConstantsSetup() {
        API_USERNAME = propertyValue(PATH_TO_RESOURCE, ENV_PROPERTIES_FILE_NAME, "username");
        API_TOKEN = propertyValue(PATH_TO_RESOURCE, ENV_PROPERTIES_FILE_NAME, "token");
        API_URL_SUFFIX = propertyValue(PATH_TO_RESOURCE, ENV_PROPERTIES_FILE_NAME, "apiURLSuffix");

        BASE_URL = System.getProperty("baseURL");
        if (BASE_URL == null) {
            BASE_URL = propertyValue(PATH_TO_RESOURCE, ENV_PROPERTIES_FILE_NAME, "baseURL");
        }

        API_URL = BASE_URL + API_URL_SUFFIX;
    }
}
