package course_project.api.stepsDefinitionsAPI;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import static course_project.api.queries.QueryFormats.*;
import static course_project.api.requestAssemblers.CreateTaskRequestAssembler.assembleCreateTaskRequest;
import static course_project.api.requestAssemblers.GetTaskRequestAssembler.assembleGetTaskRequest;
import static course_project.api.requestAssemblers.RemoveTaskRequestAssembler.assembleRemoveTaskRequest;
import static course_project.ui.stepsDefinitionsUI.preAndPostConditions.PreConditions.newProjectId;
import static course_project.utils.EnvPropertiesSetup.*;

public class TaskSteps {
    private static String newTaskId;

    @When("Send task creation API request")
    public void createTaskViaAPI() {
        Response createTaskResponse = postRequest(API_USERNAME, API_TOKEN,
                assembleCreateTaskRequest(newProjectId).toString());
        createTaskResponse.then().statusCode(200);
        newTaskId = createTaskResponse.jsonPath().getString("result");
    }

    @Then("Task should be created")
    public void checkWhetherTaskCreated() {
        Response getTaskResponse = getRequest(API_USERNAME, API_TOKEN,
                assembleGetTaskRequest(newTaskId).toString());
        getTaskResponse.then().statusCode(200);

        String actualTaskTitle = getTaskResponse.jsonPath().getString("result.title");

        Assert.assertEquals(actualTaskTitle, TESTDATA_TASK_TITLE);
    }

    @When("Send task remove API request")
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
