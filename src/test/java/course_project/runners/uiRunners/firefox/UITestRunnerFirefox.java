package course_project.runners.uiRunners.firefox;

import com.codeborne.selenide.Configuration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "rerun:target/failed-scenarios/failedScenariosFirefox"
        },
        features = "src/test/resources/features/uiTests",
        glue = {"course_project.ui.stepsDefinitionsUI", "course_project.api.stepsDefinitionsAPI"}
)
public class UITestRunnerFirefox extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    public Object[][] scenarios() {
        Configuration.browser = "firefox";
        Configuration.headless = false;
        return super.scenarios();
    }
}
