package course_project.api.queries;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static course_project.envPropertiesSetup.EnvAuthAndCookiesSetup.API_URL;

public class QueryFormats {
    public static Response getRequest(String username, String token, String getRequestBody) {
        return RestAssured.given()
                .auth().basic(username, token)
                .body(getRequestBody)
                .when()
                .get(API_URL);
    }

    public static Response postRequest(String username, String token, String postRequestBody) {
        return RestAssured.given()
                .auth().basic(username, token)
                .body(postRequestBody)
                .when()
                .post(API_URL);
    }

    public static Response deleteRequest(String username, String token, String deleteRequestBody) {
        return RestAssured.given()
                .auth().basic(username, token)
                .body(deleteRequestBody)
                .when()
                .delete(API_URL);
    }
}
