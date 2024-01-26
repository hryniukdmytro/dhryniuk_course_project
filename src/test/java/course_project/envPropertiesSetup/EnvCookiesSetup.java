package course_project.envPropertiesSetup;

import static course_project.envPropertiesSetup.GetPropertiesFromFile.ENV_PROPERTIES_FILE_NAME;
import static course_project.envPropertiesSetup.GetPropertiesFromFile.PATH_TO_RESOURCE;
import static course_project.envPropertiesSetup.GetPropertiesFromFile.propertyValue;

public class EnvCookiesSetup {
    public static String COOKIE_NAME;
    public static String COOKIE_VALUE;

    public static void cookieConstantsSetup() {
        COOKIE_NAME = propertyValue(PATH_TO_RESOURCE, ENV_PROPERTIES_FILE_NAME, "cookieName");
        COOKIE_VALUE = propertyValue(PATH_TO_RESOURCE, ENV_PROPERTIES_FILE_NAME, "cookieValue");
    }
}
