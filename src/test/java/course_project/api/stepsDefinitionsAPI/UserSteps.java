package course_project.api.stepsDefinitionsAPI;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import static course_project.api.queries.QueryFormats.*;
import static course_project.api.requestAssemblers.userRequests.CreateUserRequestAssembler.assembleCreateUserRequest;
import static course_project.api.requestAssemblers.userRequests.GetUserRequestAssembler.assembleGetUserRequest;
import static course_project.api.requestAssemblers.userRequests.RemoveUserRequestAssembler.assembleRemoveUserRequest;
import static course_project.envPropertiesSetup.EnvAuthAndCookiesSetup.*;
import static course_project.envPropertiesSetup.EnvTestDataSetup.TESTDATA_NEW_USER_NAME;

public class UserSteps {

    private static String newUserId;

    @When("Send user creation API request")
    public void createUserViaAPI() {
        Response userCreationResponse = postRequest(API_USERNAME, API_TOKEN,
                assembleCreateUserRequest().toString());
        userCreationResponse.then().statusCode(200);
        newUserId = userCreationResponse.jsonPath().getString("result");
    }

    @Then("User should be created")
    public void checkWhetherCreatedUserCreated() {
        Response getUserResponse = getRequest(API_USERNAME, API_TOKEN,
                assembleGetUserRequest(newUserId).toString());
        getUserResponse.then().statusCode(200);

        String actualUsername = getUserResponse.jsonPath().getString("result.username");
        Assert.assertEquals(actualUsername, TESTDATA_NEW_USER_NAME);
    }

    @When("Send user remove API request")
    public void removeUserViaAPI() {
        Response userRemoveResponse = deleteRequest(API_USERNAME, API_TOKEN,
                assembleRemoveUserRequest(newUserId).toString());
        userRemoveResponse.then().statusCode(200);
    }

    @Then("User should be removed")
    public void checkWhetherCreatedUserRemoved() {
        Response getUserResponse = getRequest(API_USERNAME, API_TOKEN,
                assembleGetUserRequest(newUserId).toString());
        getUserResponse.then().statusCode(200);

        String doesUserExist = getUserResponse.jsonPath().getString("result");
        Assert.assertNull(doesUserExist);
    }
}