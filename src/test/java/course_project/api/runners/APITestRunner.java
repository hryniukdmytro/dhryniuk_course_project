package course_project.api.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        features = "src/test/resources/features/apiTests",
        glue = {"course_project/api/stepsDefinitionsAPI"}
)

public class APITestRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider()
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
