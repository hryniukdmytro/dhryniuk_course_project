package course_project.runners.uiRunners.chromeHeadless;

import com.codeborne.selenide.Configuration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

import java.io.File;

@CucumberOptions(
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        },
        features = "@target/failed-scenarios/failedScenariosChromeHeadless",
        glue = {"course_project.ui.stepsDefinitionsUI", "course_project.api.stepsDefinitionsAPI"}
)
public class RerunTestRunnerChromeHeadless extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    public Object[][] scenarios() {
        Configuration.browser = "chrome";
        Configuration.headless = true;

        String filePath = "target/failed-scenarios/failedScenariosChromeHeadless";
        File file = new File(filePath);

        if (file.exists() && file.length() > 0) {
            System.out.println("Failed scenarios found for Chrome Headless. Running tests again.");
            return super.scenarios();
        } else {
            System.out.println("No failed scenarios for Chrome Headless");
            return new Object[0][0];
        }
    }
}
