package course_project.ui.stepsDefinitions.preAndPostConditions;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static course_project.utils.EnvPropertiesSetup.*;


public class Hooks {

    @Before
    public void beforeScenario() {
        authConstantsSetup();
        cookieConstantsSetup();
        testDataConstantsSetup();
    }


    @After
    public void afterScenario() {
        Selenide.closeWebDriver();
    }
}
