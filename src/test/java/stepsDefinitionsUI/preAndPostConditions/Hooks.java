package stepsDefinitionsUI.preAndPostConditions;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static envPropertiesSetup.EnvAuthAndCookiesSetup.*;
import static envPropertiesSetup.EnvCookiesSetup.cookieConstantsSetup;
import static envPropertiesSetup.EnvTestDataSetup.mapTaskColumnsIds;
import static envPropertiesSetup.EnvTestDataSetup.testDataConstantsSetup;
import static envPropertiesSetup.Log4jInitializer.initializeLog4j;

public class Hooks {
    // Setup constants & Log4j
    @Before
    public void beforeScenario() {
        authConstantsSetup();
        cookieConstantsSetup();
        testDataConstantsSetup();
        mapTaskColumnsIds();
        initializeLog4j();
    }

    @After
    public void afterScenario() {
        Selenide.closeWebDriver();
    }
}
