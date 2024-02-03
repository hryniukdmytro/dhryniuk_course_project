package course_project.runners.uiRunners.taskFeatures;

import com.codeborne.selenide.Configuration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "rerun:target/failed-scenarios/failedScenariosChromeHeadless"
        },
        features = "src/test/resources/features/uiTests/taskTests.feature",
        glue = {"course_project.ui.stepsDefinitionsUI", "course_project.api.stepsDefinitionsAPI"}
)
public class TaskTestRunnerChromeHeadless extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider
    public Object[][] scenarios() {
        Configuration.browser = "chrome";
        Configuration.headless = true;
        return super.scenarios();
    }
}
