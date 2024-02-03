package course_project.api.stepsDefinitionsAPI;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import static course_project.api.queries.QueryFormats.*;
import static course_project.api.requestAssemblers.userRequests.CreateUserRequestAssembler.assembleCreateUserRequest;
import static course_project.api.requestAssemblers.userRequests.GetUserRequestAssembler.assembleGetUserRequest;
import static course_project.api.requestAssemblers.userRequests.RemoveUserRequestAssembler.assembleRemoveUserRequest;
import static course_project.api.stepsDefinitionsAPI.GenericAPISteps.assertAPIResponseStatusCode;
import static course_project.envPropertiesSetup.EnvAuthAndCookiesSetup.*;
import static course_project.envPropertiesSetup.EnvTestDataSetup.TESTDATA_NEW_USER_NAME;

public class UserSteps {
    private static String newUserId;

    @When("User creation request was sent via API")
    public void createUserViaAPI() {
        Response userCreationResponse = postRequest(API_USERNAME, API_TOKEN,
                assembleCreateUserRequest().toString());
        assertAPIResponseStatusCode(userCreationResponse);
        newUserId = userCreationResponse.jsonPath().getString("result");
    }

    @Then("Verify that user is created")
    public void verifyThatUserIsCreated() {
        Response getUserResponse = getRequest(API_USERNAME, API_TOKEN,
                assembleGetUserRequest(newUserId).toString());
        assertAPIResponseStatusCode(getUserResponse);
        String actualUsername = getUserResponse.jsonPath().getString("result.username");
        Assert.assertEquals(actualUsername, TESTDATA_NEW_USER_NAME);
    }

    @When("Remove last created user request was sent via API")
    public void removeUserViaAPI() {
        Response userRemoveResponse = deleteRequest(API_USERNAME, API_TOKEN,
                assembleRemoveUserRequest(newUserId).toString());
        assertAPIResponseStatusCode(userRemoveResponse);
    }

    @Then("Verify that user is removed")
    public void verifyThatUserIsRemoved() {
        Response getUserResponse = getRequest(API_USERNAME, API_TOKEN,
                assembleGetUserRequest(newUserId).toString());
        assertAPIResponseStatusCode(getUserResponse);
        String doesUserExist = getUserResponse.jsonPath().getString("result");
        Assert.assertNull(doesUserExist);
    }
}