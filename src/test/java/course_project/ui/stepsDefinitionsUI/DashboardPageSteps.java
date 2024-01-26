package course_project.ui.stepsDefinitionsUI;

import course_project.ui.elements.MainPageElements;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;

public class DashboardPageSteps extends MainPageElements {

    @When("Main page should be displayed after successful login")
    public void isDashboardDisplayed() {
        Assert.assertTrue(mainPageBody().isDisplayed());
    }

    @When("Click on the 'New project' button")
    public void clickNewProjectButton() {
        newProjectButton().shouldBe(visible);
        newProjectButton().click();
    }
}
