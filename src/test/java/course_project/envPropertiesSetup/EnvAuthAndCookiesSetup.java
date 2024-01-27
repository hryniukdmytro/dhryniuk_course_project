package course_project.envPropertiesSetup;


import static course_project.envPropertiesSetup.GetPropertiesFromFile.*;

public class EnvAuthAndCookiesSetup {
    public static String API_URL;
    public static String BASE_URL;
    public static String API_USERNAME;
    public static String API_TOKEN;


    public static void authConstantsSetup() {
        API_URL = propertyValue(PATH_TO_RESOURCE, ENV_PROPERTIES_FILE_NAME, "apiURL");
        BASE_URL = propertyValue(PATH_TO_RESOURCE, ENV_PROPERTIES_FILE_NAME, "baseURL");
        API_USERNAME = propertyValue(PATH_TO_RESOURCE, ENV_PROPERTIES_FILE_NAME, "username");
        API_TOKEN = propertyValue(PATH_TO_RESOURCE, ENV_PROPERTIES_FILE_NAME, "token");
    }
}