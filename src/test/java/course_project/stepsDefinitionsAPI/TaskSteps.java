package course_project.stepsDefinitionsAPI;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import static api.queries.QueryFormats.*;
import static api.requestAssemblers.taskRequests.CreateTaskRequestAssembler.assembleCreateTaskRequest;
import static api.requestAssemblers.taskRequests.GetTaskRequestAssembler.assembleGetTaskRequest;
import static api.requestAssemblers.taskRequests.RemoveTaskRequestAssembler.assembleRemoveTaskRequest;
import static course_project.stepsDefinitionsAPI.ProjectSteps.newProjectId;
import static setup.EnvAuthAndCookiesSetup.*;

public class TaskSteps {
    public static String newTaskId;

    @When("Task with name {string} was added to the last created project via API")
    public void createTaskViaAPI(String taskTitle) {
        Response createTaskResponse = postRequest(API_USERNAME, API_TOKEN,
                assembleCreateTaskRequest(newProjectId, taskTitle).toString());
        createTaskResponse.then().statusCode(200);
        newTaskId = createTaskResponse.jsonPath().getString("result");
    }

    @Then("Task with name {string} should be created")
    public void checkWhetherTaskCreated(String taskTitle) {
        Response getTaskResponse = getRequest(API_USERNAME, API_TOKEN,
                assembleGetTaskRequest(newTaskId).toString());
        getTaskResponse.then().statusCode(200);

        String actualTaskTitle = getTaskResponse.jsonPath().getString("result.title");

        Assert.assertEquals(actualTaskTitle, taskTitle);
    }

    @When("API request to remove last created task has been sent")
    public void removeTaskViaAPI() {
        Response removeTaskResponse = deleteRequest(API_USERNAME, API_TOKEN,
                assembleRemoveTaskRequest(newTaskId).toString());
        removeTaskResponse.then().statusCode(200);
    }

    @Then("Task should be removed")
    public void checkWhetherTaskRemoved() {
        Response getTaskResponse = getRequest(API_USERNAME, API_TOKEN,
                assembleGetTaskRequest(newTaskId).toString());
        getTaskResponse.then().statusCode(200);

        String doesTaskExist = getTaskResponse.jsonPath().getString("result");
        Assert.assertNull(doesTaskExist);
    }
}
