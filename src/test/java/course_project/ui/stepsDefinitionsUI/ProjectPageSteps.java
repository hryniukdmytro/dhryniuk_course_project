package course_project.ui.stepsDefinitionsUI;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import course_project.ui.elements.ProjectPageElements;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static course_project.envPropertiesSetup.EnvTestDataSetup.*;

public class ProjectPageSteps extends ProjectPageElements {


    // <-- Drag-n-Drops --->

    @When("Task {string} was moved to {string} column")
    public void startDragNDrop(String taskTitle, String columnName) {
        SelenideElement taskElement = findTaskOnBoard(taskTitle);
        taskElement.shouldBe(visible);

        Integer columnId = COLUMN_ID_MAP.get(columnName);

        actions().clickAndHold(taskElement).moveToElement(taskBoardColumn(columnId)).perform();
    }

    // <------ Fills ------>

    @When("Selected project to copy to is {string}")
    public void selectProjectToCopyTo(String givenProjectName) {
        selectProjectDropdownOptionByName(givenProjectName).shouldBe(visible);
        selectProjectDropdownOptionByName(givenProjectName).click();
    }

    // <----- Asserts & Checks ----->

    @Then("Task {string} should be displayed in {string} column")
    public void verifyTaskInColumn(String taskTitle, String columnName) {
        Integer columnId = COLUMN_ID_MAP.get(columnName);
        actions().release().perform();
        sleep(25);

        taskBoardColumn(columnId).shouldHave(Condition.text(taskTitle));
    }
}
