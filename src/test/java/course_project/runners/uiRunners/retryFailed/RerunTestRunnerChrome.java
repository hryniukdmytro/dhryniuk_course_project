package course_project.runners.uiRunners.retryFailed;

import com.codeborne.selenide.Configuration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.DataProvider;

import java.io.File;

@CucumberOptions(
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        },
        features = "@target/failed-scenarios/failedScenariosChrome",
        glue = {"course_project.ui.stepsDefinitionsUI", "course_project.api.stepsDefinitionsAPI"}
)
@Log4j
public class RerunTestRunnerChrome extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider
    public Object[][] scenarios() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        String filePath = "target/failed-scenarios/failedScenariosChrome";
        File file = new File(filePath);
        if (file.exists() && file.length() > 0) {
            System.out.println("Failed scenarios found for Chrome. Running tests again.");
            return super.scenarios();
        } else {
            log.info("No failed scenarios for Chrome");
            return new Object[0][0];
        }
    }
}
