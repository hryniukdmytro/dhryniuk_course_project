package course_project.ui.stepsDefinitions.preAndPostConditions;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;

import static course_project.api.queries.QueryFormats.postRequest;
import static course_project.api.requestAssemblers.CreateProjectRequestAssembler.createProjectRequestAssembling;
import static course_project.api.requestAssemblers.CreateTaskRequestAssembler.createTaskRequestAssembling;
import static course_project.utils.EnvPropertiesSetup.*;

public class PreConditions {
    String newProjectId;
    String newTaskId;


    @Given("User should have a project")
    public void createProjectViaAPI() {
        Response projectCreationResponse = postRequest(API_USERNAME, API_TOKEN,
                createProjectRequestAssembling().toString());
        projectCreationResponse.then().statusCode(200);
        newProjectId = projectCreationResponse.jsonPath().getString("result");
    }

    @Given("User should have project opened")
    public void openNewProject() {
        Selenide.open(BASE_URL + "/board/" + newProjectId);
        Selenide.refresh();
    }

    @Given("Project should have active task")
    public void createTask() {
        Response taskCreationResponse = postRequest(API_USERNAME, API_TOKEN,
                createTaskRequestAssembling(newProjectId).toString());
        taskCreationResponse.then().statusCode(200);
        newTaskId = taskCreationResponse.jsonPath().getString("result");
    }
    @Given("User should have task opened")
    public void openNewTask() {
        Selenide.open(BASE_URL + "/task/" + newTaskId);
        Selenide.refresh();
    }
}
