package course_project.ui.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
                },
        features = "src/test/resources/features/uiTests",
        glue = {"course_project/ui/stepsDefinitionsUI"}
)

public class UITestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
