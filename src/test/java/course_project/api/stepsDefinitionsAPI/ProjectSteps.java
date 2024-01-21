package course_project.api.stepsDefinitionsAPI;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import static course_project.api.queries.QueryFormats.*;
import static course_project.api.requestAssemblers.CreateProjectRequestAssembler.assembleCreateProjectRequest;
import static course_project.api.requestAssemblers.GetProjectByIdRequestAssembler.assembleGetProjectByIdRequest;
import static course_project.api.requestAssemblers.RemoveProjectRequestAssembler.assembleRemoveProjectRequest;
import static course_project.utils.EnvPropertiesSetup.*;

public class ProjectSteps {
    private static String newProjectId;

    @When("Send project creation API request")
    public void createProjectViaAPI() {
        Response projectCreationResponse = postRequest(API_USERNAME, API_TOKEN,
                assembleCreateProjectRequest().toString());
        projectCreationResponse.then().statusCode(200);
        newProjectId = projectCreationResponse.jsonPath().getString("result");
    }

    @Then("Project should be created")
    public void checkWhetherProjectIsCreated() {
        Response getProjectByIdResponse = getRequest(API_USERNAME, API_TOKEN,
                assembleGetProjectByIdRequest(newProjectId).toString());
        getProjectByIdResponse.then().statusCode(200);

        String actualProjectName = getProjectByIdResponse.jsonPath().getString("result.name");

        Assert.assertEquals(actualProjectName, TESTDATA_PROJECT_NAME);}

    @When("Send project remove API request")
    public void removeProjectViaAPI() {
        Response removeProjectResponse = deleteRequest(API_USERNAME, API_TOKEN,
                assembleRemoveProjectRequest(newProjectId).toString());
        removeProjectResponse.then().statusCode(200);
    }

    @Then("Project should be removed")
    public void checkWhetherProjectIsRemoved() {
        Response getProjectByIdResponse = getRequest(API_USERNAME, API_TOKEN,
                assembleGetProjectByIdRequest(newProjectId).toString());
        getProjectByIdResponse.then().statusCode(200);

        String actualProjectState = getProjectByIdResponse.jsonPath().getString("result");

        Assert.assertNull(actualProjectState);
    }
}
