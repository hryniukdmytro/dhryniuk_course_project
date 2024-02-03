package course_project.stepsDefinitionsAPI;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import static api.queries.QueryFormats.*;
import static api.requestAssemblers.projectRequests.AddProjectMemberRequestAssembler.assembleAddProjectMemberRequest;
import static api.requestAssemblers.projectRequests.CreateProjectRequestWithSetNameAssembler.assembleCreateProjectWithSetNameRequest;
import static api.requestAssemblers.projectRequests.GetProjectByIdRequestAssembler.assembleGetProjectByIdRequest;
import static api.requestAssemblers.projectRequests.RemoveProjectRequestAssembler.assembleRemoveProjectRequest;
import static setup.EnvAuthAndCookiesSetup.*;

public class ProjectSteps {
    public static String newProjectId;

    @Then("Project with name {string} should be created")
    public void checkWhetherProjectIsCreated(String projectName) {
        Response getProjectByIdResponse = getRequest(API_USERNAME, API_TOKEN,
                assembleGetProjectByIdRequest(newProjectId).toString());
        getProjectByIdResponse.then().statusCode(200);

        String actualProjectName = getProjectByIdResponse.jsonPath().getString("result.name");

        Assert.assertEquals(actualProjectName, projectName);}

    @When("API request to remove last created project has been sent")
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

    @When("API request to create a project with name {string} was sent")
    public void createProjectWithSetNameViaAPI(String projectName) {
        Response createProjectWithSetNameResponse = postRequest(API_USERNAME, API_TOKEN,
                assembleCreateProjectWithSetNameRequest(projectName).toString());
        createProjectWithSetNameResponse.then().statusCode(200);
        newProjectId = createProjectWithSetNameResponse.jsonPath().getString("result");
    }

    @When("User was set as member of last created project via API")
    public void setUserAsProjectMember() {
        Response addProjectMemberResponse = postRequest(API_USERNAME, API_TOKEN,
                assembleAddProjectMemberRequest(newProjectId).toString());
        addProjectMemberResponse.then().statusCode(200);
    }
}
