package course_project.api.stepsDefinitionsAPI;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import static course_project.api.queries.QueryFormats.*;
import static course_project.api.requestAssemblers.taskRequests.CreateTaskRequestAssembler.assembleCreateTaskRequest;
import static course_project.api.requestAssemblers.taskRequests.GetTaskRequestAssembler.assembleGetTaskRequest;
import static course_project.api.requestAssemblers.taskRequests.RemoveTaskRequestAssembler.assembleRemoveTaskRequest;
import static course_project.api.stepsDefinitionsAPI.GenericAPISteps.assertAPIResponseStatusCode;
import static course_project.api.stepsDefinitionsAPI.ProjectSteps.newProjectId;
import static course_project.envPropertiesSetup.EnvAuthAndCookiesSetup.*;

public class TaskSteps {
    public static String newTaskId;

    @When("Task with name {string} was added to the last created project via API")
    public void createTaskViaAPI(String taskTitle) {
        Response createTaskResponse = postRequest(API_USERNAME, API_TOKEN,
                assembleCreateTaskRequest(newProjectId, taskTitle).toString());
        assertAPIResponseStatusCode(createTaskResponse);
        newTaskId = createTaskResponse.jsonPath().getString("result");
    }

    @Then("Verify that task with name {string} is created")
    public void verifyThatTaskIsCreated(String taskTitle) {
        Response getTaskResponse = getRequest(API_USERNAME, API_TOKEN,
                assembleGetTaskRequest(newTaskId).toString());
        assertAPIResponseStatusCode(getTaskResponse);
        String actualTaskTitle = getTaskResponse.jsonPath().getString("result.title");
        Assert.assertEquals(actualTaskTitle, taskTitle);
    }

    @When("API request to remove last created task has been sent")
    public void removeTaskViaAPI() {
        Response removeTaskResponse = deleteRequest(API_USERNAME, API_TOKEN,
                assembleRemoveTaskRequest(newTaskId).toString());
        assertAPIResponseStatusCode(removeTaskResponse);
    }

    @Then("Verify that task is removed")
    public void verifyThatTaskIsRemoved() {
        Response getTaskResponse = getRequest(API_USERNAME, API_TOKEN,
                assembleGetTaskRequest(newTaskId).toString());
        assertAPIResponseStatusCode(getTaskResponse);
        String doesTaskExist = getTaskResponse.jsonPath().getString("result");
        Assert.assertNull(doesTaskExist);
    }
}
