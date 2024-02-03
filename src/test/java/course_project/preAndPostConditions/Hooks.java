package course_project.preAndPostConditions;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static setup.EnvAuthAndCookiesSetup.*;
import static setup.EnvCookiesSetup.cookieConstantsSetup;
import static setup.EnvTestDataSetup.mapTaskColumnsIds;
import static setup.EnvTestDataSetup.testDataConstantsSetup;


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
