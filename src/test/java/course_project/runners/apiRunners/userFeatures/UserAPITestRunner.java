package course_project.runners.apiRunners.userFeatures;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        features = "src/test/resources/features/apiTests/userAPITests.feature",
        glue = {"course_project/api/stepsDefinitionsAPI",
        "course_project/ui/stepsDefinitionsUI/preAndPostConditions"}
)

public class UserAPITestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
