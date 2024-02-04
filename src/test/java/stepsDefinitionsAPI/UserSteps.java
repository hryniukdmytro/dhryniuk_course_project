package stepsDefinitionsAPI;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import static api.queries.QueryFormats.*;

import static api.queries.ResponseStructure.RESULT;
import static api.queries.ResponseStructure.RESULT_USERNAME;
import static api.requestAssemblers.userRequests.CreateUserRequestAssembler.assembleCreateUserRequest;
import static api.requestAssemblers.userRequests.GetUserRequestAssembler.assembleGetUserRequest;
import static api.requestAssemblers.userRequests.RemoveUserRequestAssembler.assembleRemoveUserRequest;
import static envPropertiesSetup.EnvAuthAndCookiesSetup.*;
import static envPropertiesSetup.EnvTestDataSetup.TESTDATA_NEW_USER_NAME;
import static stepsDefinitionsAPI.GenericAPISteps.getResponseResultElement;

public class UserSteps {
    private static String newUserId;

    @When("User creation request was sent via API")
    public void createUserViaAPI() {
        Response userCreationResponse = postRequest(API_USERNAME, API_TOKEN,
                assembleCreateUserRequest().toString());
        GenericAPISteps.assertAPIResponseStatusCode(userCreationResponse);
        newUserId = getResponseResultElement(userCreationResponse, RESULT);
    }

    @Then("Verify that user is created")
    public void verifyThatUserIsCreated() {
        Response getUserResponse = getRequest(API_USERNAME, API_TOKEN,
                assembleGetUserRequest(newUserId).toString());
        GenericAPISteps.assertAPIResponseStatusCode(getUserResponse);
        String actualUsername = getResponseResultElement(getUserResponse, RESULT_USERNAME);
        Assert.assertEquals(actualUsername, TESTDATA_NEW_USER_NAME);
    }

    @When("Remove last created user request was sent via API")
    public void removeUserViaAPI() {
        Response userRemoveResponse = deleteRequest(API_USERNAME, API_TOKEN,
                assembleRemoveUserRequest(newUserId).toString());
        GenericAPISteps.assertAPIResponseStatusCode(userRemoveResponse);
    }

    @Then("Verify that user is removed")
    public void verifyThatUserIsRemoved() {
        Response getUserResponse = getRequest(API_USERNAME, API_TOKEN,
                assembleGetUserRequest(newUserId).toString());
        GenericAPISteps.assertAPIResponseStatusCode(getUserResponse);
        String doesUserExist = getResponseResultElement(getUserResponse, RESULT);
        Assert.assertNull(doesUserExist);
    }
}