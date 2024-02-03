package setup;

public class EnvAuthAndCookiesSetup {
    public static String API_URL;
    public static String API_URL_SUFFIX;
    public static String BASE_URL;
    public static String API_USERNAME;
    public static String API_TOKEN;

    public static void authConstantsSetup() {
        API_USERNAME = GetPropertiesFromFile.propertyValue(GetPropertiesFromFile.PATH_TO_RESOURCE, GetPropertiesFromFile.ENV_PROPERTIES_FILE_NAME, "username");
        API_TOKEN = GetPropertiesFromFile.propertyValue(GetPropertiesFromFile.PATH_TO_RESOURCE, GetPropertiesFromFile.ENV_PROPERTIES_FILE_NAME, "token");
        API_URL_SUFFIX = GetPropertiesFromFile.propertyValue(GetPropertiesFromFile.PATH_TO_RESOURCE, GetPropertiesFromFile.ENV_PROPERTIES_FILE_NAME, "apiURLSuffix");

        BASE_URL = System.getProperty("baseURL");
        if (BASE_URL == null) {
            BASE_URL = GetPropertiesFromFile.propertyValue(GetPropertiesFromFile.PATH_TO_RESOURCE, GetPropertiesFromFile.ENV_PROPERTIES_FILE_NAME, "baseURL");
        }

        API_URL = BASE_URL + API_URL_SUFFIX;
    }
}
