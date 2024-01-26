package course_project.runners.uiRunners.chrome;

import com.codeborne.selenide.Configuration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        },
        features = "@target/failed-scenarios/failedScenariosChrome",
        glue = {"course_project/ui/stepsDefinitionsUI",
                "course_project/api/stepsDefinitionsAPI"}
)
public class RerunTestRunnerChrome extends AbstractTestNGCucumberTests {

    static {
        Configuration.browser = "chrome";
        Configuration.headless = false;
    }

    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
