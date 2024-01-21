package course_project.ui.stepsDefinitionsUI.preAndPostConditions;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;

import static course_project.api.queries.QueryFormats.postRequest;
import static course_project.api.requestAssemblers.CreateProjectRequestAssembler.assembleCreateProjectRequest;
import static course_project.api.requestAssemblers.CreateTaskRequestAssembler.assembleCreateTaskRequest;
import static course_project.utils.EnvPropertiesSetup.*;

public class PreConditions {
    public static String newProjectId;
    private static String newTaskId;


    @Given("User should have a project")
    public void prepareProjectViaAPI() {
        Response projectCreationResponse = postRequest(API_USERNAME, API_TOKEN,
                assembleCreateProjectRequest().toString());
        projectCreationResponse.then().statusCode(200);
        newProjectId = projectCreationResponse.jsonPath().getString("result");
    }

    @Given("User should have project opened")
    public void openNewProject() {
        Selenide.open(BASE_URL + "/board/" + newProjectId);
        Selenide.refresh();
    }

    @Given("Project should have active task")
    public void prepareTaskViaAPI() {
        Response taskCreationResponse = postRequest(API_USERNAME, API_TOKEN,
                assembleCreateTaskRequest(newProjectId).toString());
        taskCreationResponse.then().statusCode(200);
        newTaskId = taskCreationResponse.jsonPath().getString("result");
    }
    @Given("User should have task opened")
    public void openNewTask() {
        Selenide.open(BASE_URL + "/task/" + newTaskId);
        Selenide.refresh();
    }
}
