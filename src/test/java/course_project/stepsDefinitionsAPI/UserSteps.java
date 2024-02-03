package course_project.stepsDefinitionsAPI;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import static api.queries.QueryFormats.*;
import static api.requestAssemblers.userRequests.CreateUserRequestAssembler.assembleCreateUserRequest;
import static api.requestAssemblers.userRequests.GetUserRequestAssembler.assembleGetUserRequest;
import static api.requestAssemblers.userRequests.RemoveUserRequestAssembler.assembleRemoveUserRequest;
import static setup.EnvAuthAndCookiesSetup.*;
import static setup.EnvTestDataSetup.TESTDATA_NEW_USER_NAME;

public class UserSteps {

    private static String newUserId;

    @When("User creation request was sent via API")
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

    @When("Remove last created user request was sent via API")
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