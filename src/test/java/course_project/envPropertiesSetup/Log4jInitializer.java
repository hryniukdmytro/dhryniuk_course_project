package course_project.envPropertiesSetup;

import org.apache.log4j.PropertyConfigurator;

public class Log4jInitializer {
    public static void initializeLog4j() {
        PropertyConfigurator.configure("src/test/resources/properties/log4j.properties");
    }
}
