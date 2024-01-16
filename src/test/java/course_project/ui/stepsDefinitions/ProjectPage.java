package course_project.ui.stepsDefinitions;

import course_project.ui.elements.MainPageElements;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends MainPageElements {

    private String expectedProjectTitle;
    private String addedComment;

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

    @When("Fill the form with valid data \\(name {string})")
    public void fillNewProjectForm(String projectName) {
        expectedProjectTitle = projectName;
        projectNameTextField().shouldBe(visible);

        projectNameTextField().sendKeys(projectName);
    }

    @When("Fill the task creation form \\(task name {string} and description {string})")
    public void fillTheTaskCreationForm(String taskName, String taskDesc) {
        newTaskTitle().shouldBe(visible);
        newTaskDescriptionTextField().shouldBe(visible);

        newTaskTitle().sendKeys(taskName);
        newTaskDescriptionTextField().sendKeys(taskDesc);
    }

    @When("Fill the comment form with valid data \\({string})")
    public void fillTheCommentForm(String commentToAdd) {
        addedComment = commentToAdd;
        commentTextArea().shouldBe(visible);
        commentTextArea().sendKeys(commentToAdd);
    }


    // <----- Asserts & Checks ----->

    @Then("New project should be opened and displayed")
    public void isNewProjectDisplayed() {
        $x("//h1/span[@class='title' and contains(text(), '" + expectedProjectTitle + "')]")
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
        Assert.assertEquals(addedComment().getText(),addedComment);
    }
}
