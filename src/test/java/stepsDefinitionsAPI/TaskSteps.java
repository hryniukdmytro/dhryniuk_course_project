package stepsDefinitionsAPI;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import static api.queries.QueryFormats.*;
import static api.queries.ResponseResultStructure.RESULT;
import static api.queries.ResponseResultStructure.RESULT_TITLE;
import static api.requestAssemblers.taskRequests.CreateTaskRequestAssembler.assembleCreateTaskRequest;
import static api.requestAssemblers.taskRequests.GetTaskRequestAssembler.assembleGetTaskRequest;
import static api.requestAssemblers.taskRequests.RemoveTaskRequestAssembler.assembleRemoveTaskRequest;
import static envPropertiesSetup.EnvAuthAndCookiesSetup.*;
import static stepsDefinitionsAPI.GenericAPISteps.getResponseResultElement;

public class TaskSteps {
    public static String newTaskId;

    @When("Task with name {string} was added to the last created project via API")
    public void createTaskViaAPI(String taskTitle) {
        Response createTaskResponse = postRequest(API_USERNAME, API_TOKEN,
                assembleCreateTaskRequest(ProjectSteps.newProjectId, taskTitle).toString());
        GenericAPISteps.assertAPIResponseStatusCode(createTaskResponse);
        newTaskId = getResponseResultElement(createTaskResponse, RESULT);
    }

    @Then("Verify that task with name {string} is created")
    public void verifyThatTaskIsCreated(String taskTitle) {
        Response getTaskResponse = getRequest(API_USERNAME, API_TOKEN,
                assembleGetTaskRequest(newTaskId).toString());
        GenericAPISteps.assertAPIResponseStatusCode(getTaskResponse);
        String actualTaskTitle = getResponseResultElement(getTaskResponse, RESULT_TITLE);
        Assert.assertEquals(actualTaskTitle, taskTitle);
    }

    @When("API request to remove last created task has been sent")
    public void removeTaskViaAPI() {
        Response removeTaskResponse = deleteRequest(API_USERNAME, API_TOKEN,
                assembleRemoveTaskRequest(newTaskId).toString());
        GenericAPISteps.assertAPIResponseStatusCode(removeTaskResponse);
    }

    @Then("Verify that task is removed")
    public void verifyThatTaskIsRemoved() {
        Response getTaskResponse = getRequest(API_USERNAME, API_TOKEN,
                assembleGetTaskRequest(newTaskId).toString());
        GenericAPISteps.assertAPIResponseStatusCode(getTaskResponse);
        String doesTaskExist = getResponseResultElement(getTaskResponse, RESULT);
        Assert.assertNull(doesTaskExist);
    }
}
