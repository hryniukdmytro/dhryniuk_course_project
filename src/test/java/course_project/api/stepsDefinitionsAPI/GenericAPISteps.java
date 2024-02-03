package course_project.api.stepsDefinitionsAPI;

import io.restassured.response.Response;

import static course_project.envPropertiesSetup.EnvTestDataSetup.HTTP_STATUS_CODE_200;

public class GenericAPISteps {
    public static void assertAPIResponseStatusCode(Response response) {
        response.then().statusCode(HTTP_STATUS_CODE_200);
    }
}
