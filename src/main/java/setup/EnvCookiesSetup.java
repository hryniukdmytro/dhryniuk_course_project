package setup;

public class EnvCookiesSetup {
    public static String COOKIE_NAME;
    public static String COOKIE_VALUE;

    public static void cookieConstantsSetup() {
        COOKIE_NAME = GetPropertiesFromFile.propertyValue(GetPropertiesFromFile.PATH_TO_RESOURCE, GetPropertiesFromFile.ENV_PROPERTIES_FILE_NAME, "cookieName");
        COOKIE_VALUE = GetPropertiesFromFile.propertyValue(GetPropertiesFromFile.PATH_TO_RESOURCE, GetPropertiesFromFile.ENV_PROPERTIES_FILE_NAME, "cookieValue");
    }
}
