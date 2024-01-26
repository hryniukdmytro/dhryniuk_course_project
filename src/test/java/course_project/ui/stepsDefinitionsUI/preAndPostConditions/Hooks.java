package course_project.ui.stepsDefinitionsUI.preAndPostConditions;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static course_project.envPropertiesSetup.EnvAuthAndCookiesSetup.*;
import static course_project.envPropertiesSetup.EnvCookiesSetup.cookieConstantsSetup;
import static course_project.envPropertiesSetup.EnvTestDataSetup.mapTaskColumnsIds;
import static course_project.envPropertiesSetup.EnvTestDataSetup.testDataConstantsSetup;


public class Hooks {

    // Setup constants
    @Before
    public void beforeScenario() {
        authConstantsSetup();
        cookieConstantsSetup();
        testDataConstantsSetup();
        mapTaskColumnsIds();
    }


    @After
    public void afterScenario() {
        Selenide.closeWebDriver();
    }
}
