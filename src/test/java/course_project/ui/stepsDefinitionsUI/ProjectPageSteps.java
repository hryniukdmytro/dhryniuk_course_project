package course_project.ui.stepsDefinitionsUI;

import course_project.ui.elements.MainPageElements;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static course_project.utils.EnvPropertiesSetup.*;

import static com.codeborne.selenide.Condition.*;
public class ProjectPageSteps extends MainPageElements {

    // <----- Clicks ------>

    @When("Click on the 'New project' button")
    public void clickNewProjectButton() {
        newProjectButton().shouldBe(visible);
        newProjectButton().click();
    }

    @When("Click the 'Save' button")
    public void saveNewProject() {
        modalSaveButton().shouldBe(visible);
        modalSaveButton().click();
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
        modalSaveButton().shouldBe(visible);
        modalSaveButton().click();
    }

    @When("Open the 'List' section")
    public void openListSection() {
        viewListingButton().shouldBe(visible);
        viewListingButton().click();
    }

    @When("Click the title of a new task")
    public void clickNewTaskTitle() {
        existingTaskTitle().shouldBe(visible);
        existingTaskTitle().click();
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

    @When("Click 'Yes' in appeared modal window")
    public void confirmModal() {
        yesModalButton().shouldBe(visible);
        yesModalButton().click();
    }

    @When("Click on 'Close this project' button")
    public void clickOnCloseThisProjectButton() {
        closeThisProjectButton().shouldBe(visible);
        closeThisProjectButton().click();
    }

    @When("Click on 'Configure this project' button")
    public void clickConfigureThisProjectButton() {
        configureThisProjectButton().shouldBe(visible);
        configureThisProjectButton().click();
    }

    @When("Click 'Add a sub-task' button")
    public void clickAddSubTaskButton() {
        addSubTaskButton().shouldBe(visible);
        addSubTaskButton().click();
    }

    @When("Click 'Save' button to save new sub-task")
    public void saveNewSubTask() {
        saveSubTaskButton().shouldBe(visible);
        saveSubTaskButton().click();
    }

    @When("Click the 'Duplicate to project' button")
    public void clickTheDuplicateToProjectButton() {
        duplicateToProjectButton().shouldBe(visible);
        duplicateToProjectButton().click();
    }

    @When("Click the link to copied task")
    public void clickTheLinkToCopiedTask() {
        linkToDuplicatedTask().shouldBe(visible);
        linkToDuplicatedTask().click();
    }

    // <------ Fills ------>

    @When("Fill the project creation form")
    public void fillNewProjectForm() {
        projectNameModalTextField().shouldBe(visible);
        projectNameModalTextField().sendKeys(TESTDATA_PROJECT_NAME);
    }

    @When("Fill the task creation form")
    public void fillTheTaskCreationForm() {
        formTitleTextField().shouldBe(visible);
        formTitleTextField().sendKeys(TESTDATA_TASK_TITLE);
    }

    @When("Fill the comment form")
    public void fillTheCommentForm() {
        commentModalTextArea().shouldBe(visible);
        commentModalTextArea().sendKeys(TESTDATA_COMMENT_TEXT);
    }

    @When("Fill the sub-task creation form")
    public void fillTheSubTaskCreationForm() {
        formTitleTextField().shouldBe(visible).clear();
        formTitleTextField().sendKeys(TESTDATA_SUBTASK_TITLE);
    }

    // <----- Asserts & Checks ----->

    @Then("New project should be opened and displayed")
    public void isNewProjectDisplayed() {
        projectTitle().shouldBe(visible);
        Assert.assertEquals(projectTitle().getText(), TESTDATA_PROJECT_NAME);
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

    @Then("Check the that project status is {string}")
    public void checkProjectState(String expectedProjectState) {
        summaryProjectState().shouldBe(visible);
        String summaryText = summaryProjectState().getText();

        String[] words = summaryText.split("\\s+");
        String actualProjectState = words[words.length - 1];

        Assert.assertEquals(actualProjectState, expectedProjectState);
    }

    @Then("Check that new sub-task in created")
    public void isNewSubTaskInCreated() {
        existingSubTaskTitle().shouldBe(visible);
        Assert.assertEquals(existingSubTaskTitle().getText(), TESTDATA_SUBTASK_TITLE);
    }

    @Then("Check that task is opened in {string}")
    public void isTaskOpenedInAnotherProject(String desiredProject) {
        projectTitle().shouldBe(visible);
        Assert.assertEquals(projectTitle().getText(), desiredProject);
    }
}
