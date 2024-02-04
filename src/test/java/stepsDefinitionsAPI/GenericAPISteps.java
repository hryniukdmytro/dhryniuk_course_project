package stepsDefinitionsAPI;

import api.queries.ResponseResultStructure;
import io.restassured.response.Response;

import static envPropertiesSetup.EnvTestDataSetup.HTTP_STATUS_CODE_200;

public class GenericAPISteps {
    public static void assertAPIResponseStatusCode(Response response) {
        response.then().statusCode(HTTP_STATUS_CODE_200);
    }

    public static String getResponseResultElement(Response response, ResponseResultStructure resultElementPath) {
        return response.jsonPath().getString(resultElementPath.getResponseResultElement());
    }
}
