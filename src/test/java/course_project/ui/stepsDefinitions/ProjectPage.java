package course_project.ui.stepsDefinitions;

import course_project.ui.elements.MainPageElements;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import static course_project.utils.EnvPropertiesSetup.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends MainPageElements {

    // <----- Clicks ------>

    @When("Click on the 'New project' button")
    public void clickNewProjectButton() {
        newProjectButton().shouldBe(visible);
        newProjectButton().click();
    }

    @When("Click the 'Save' button")
    public void saveNewProject() {
        saveProjectButton().shouldBe(visible);
        saveProjectButton().click();
    }

    @When("Click on gear icon to open project configurations dropdown")
    public void clickOnGearIcon() {
        projectGearIcon().shouldBe(visible);
        projectGearIcon().click();
    }

    @When("Click 'Add a new task' dropdown option")
    public void clickOnAddANewTaskOption() {
        addNewTaskButton().shouldBe(visible);
        addNewTaskButton().click();
    }

    @When("Click the 'Save' button to save the new task")
    public void clickOnSaveButton() {
        saveTaskButton().shouldBe(visible);
        saveTaskButton().click();
    }

    @When("Open the 'List' section")
    public void openListSection() {
        viewListingButton().shouldBe(visible);
        viewListingButton().click();
    }

    @When("Click the title of a new task")
    public void clickNewTaskTitle() {
        taskTitleInList().shouldBe(visible);
        taskTitleInList().click();
    }

    @When("Click the 'Close this task' button")
    public void clickCloseThisTaskButton() {
        closeTaskButton().shouldBe(visible);
        closeTaskButton().click();
    }

    @When("Click the 'Add a comment' button")
    public void clickAddACommentButton() {
        addCommentButton().shouldBe(visible);
        addCommentButton().click();
    }

    @When("Click 'Save' button to save the comment")
    public void clickSaveButton() {
        saveCommentButton().shouldBe(visible);
        saveCommentButton().click();
    }

    @When("Confirm task closing by clicking 'Yes' in 'Close Task' pop-up")
    public void confirmTaskClosing() {
        confirmTaskClosingButton().shouldBe(visible);
        confirmTaskClosingButton().click();
    }


    // <------ Fills ------>

    @When("Fill the project creation form")
    public void fillNewProjectForm() {
        projectNameTextField().shouldBe(visible);

        projectNameTextField().sendKeys(TESTDATA_PROJECT_NAME);
    }

    @When("Fill the task creation form")
    public void fillTheTaskCreationForm() {
        newTaskTitle().shouldBe(visible);
        newTaskTitle().sendKeys(TESTDATA_TASK_TITLE);
    }

    @When("Fill the comment form")
    public void fillTheCommentForm() {
        commentTextArea().shouldBe(visible);
        commentTextArea().sendKeys(TESTDATA_COMMENT_TEXT);
    }


    // <----- Asserts & Checks ----->

    @Then("New project should be opened and displayed")
    public void isNewProjectDisplayed() {
        $x("//h1/span[@class='title' and contains(text(), '" + TESTDATA_PROJECT_NAME + "')]")
                .shouldBe(visible);
    }

    @Then("Check that task status is {string}")
    public void checkTheTaskStatus(String taskStatus) {
        taskStatus().shouldBe(visible);
        Assert.assertEquals(taskStatus().getText(), taskStatus);
    }

    @Then("Check that comment is displayed")
    public void commentIsDisplayed() {
        addedComment().shouldBe(visible);
        Assert.assertEquals(addedComment().getText(), TESTDATA_COMMENT_TEXT);
    }
}
