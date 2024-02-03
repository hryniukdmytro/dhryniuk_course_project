package runners.apiRunners.taskFeatures;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        features = "src/test/resources/features/apiTests/taskAPITests.feature",
        glue = {"course_project/api/stepsDefinitionsAPI",
        "course_project/ui/stepsDefinitionsUI/preAndPostConditions"}
)

public class TaskAPITestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
