package course_project.runners.uiRunners.chromeHeadless;

import com.codeborne.selenide.Configuration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        },
        features = "@target/failed-scenarios/failedScenariosChromeHeadless",
        glue = {"course_project/ui/stepsDefinitionsUI",
                "course_project/api/stepsDefinitionsAPI"}
)
public class RerunTestRunnerChromeHeadless extends AbstractTestNGCucumberTests {

    static {
        Configuration.browser = "chrome";
        Configuration.headless = true;
    }

    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
