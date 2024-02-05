package runners.uiRunners.retryFailed;

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
        features = "@target/failed-scenarios/failedScenariosFirefox",
        glue = {"stepsDefinitionsUI", "stepsDefinitionsAPI"}
)
@Log4j
public class RerunTestRunnerFirefox extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider
    public Object[][] scenarios() {
        Configuration.browser = "firefox";
        Configuration.headless = false;
        String filePath = "target/failed-scenarios/failedScenariosFirefox";
        File file = new File(filePath);
        if (file.exists() && file.length() > 0) {
            log.info("Failed scenarios found for Firefox. Running tests again.");
            return super.scenarios();
        } else {
            log.info("No failed scenarios for Firefox");
            return new Object[0][0];
        }
    }
}
