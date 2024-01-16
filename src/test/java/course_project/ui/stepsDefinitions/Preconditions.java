package course_project.ui.stepsDefinitions;

import com.codeborne.selenide.WebDriverRunner;
import course_project.api.RequestStructure.Project.ProjectGenericData;
import course_project.api.RequestStructure.Project.ProjectParamsData;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class Preconditions {
    private static final String AUTH_USERNAME = "admin";
    private static final String AUTH_PASSWORD = "admin";

    String newProjectId;


    private void toAuthorize() {

        JSONObject authRequestBody = new JSONObject();
        authRequestBody.put("username", AUTH_USERNAME);
        authRequestBody.put("password", AUTH_PASSWORD);

        Response authResponse = RestAssured
                .given()
                .body(authRequestBody.toString())
                .auth().preemptive().basic(AUTH_USERNAME,AUTH_PASSWORD)
                .post("http://localhost/jsonrpc.php");

        int statusCode = authResponse.getStatusCode();
        System.out.println("Authorization API Response Status Code: " + statusCode);

        if (statusCode == 200) {
        } else {
            System.out.println("Authorization API Response Body: " + authResponse.prettyPrint());
        }
    }
    private JSONObject createProjectRequestAssembling(String desiredProjectName) {
        JSONObject createProjectRequestBody = new JSONObject();
        createProjectRequestBody.put("jsonrpc", 2.0);
        createProjectRequestBody.put("method", "createProject");
        createProjectRequestBody.put("id", "1792");

        JSONObject createProjectParams = new JSONObject();
        createProjectParams.put("name", desiredProjectName);
        createProjectParams.put("owner_id", "1");

        createProjectRequestBody.put("params", createProjectParams);

        return createProjectRequestBody;
    }

    @Given("User should have a project \\(Project name for test: {string})")
    public void createProjectViaAPI(String projectNameByTest) {
        toAuthorize();
        Response projectCreationResponse = RestAssured
                .given()
                .body(createProjectRequestAssembling(projectNameByTest).toString())
                .auth().preemptive().basic(AUTH_USERNAME, AUTH_PASSWORD)
                .post("http://localhost/jsonrpc.php");
        projectCreationResponse.then().statusCode(200);
        newProjectId = projectCreationResponse.jsonPath().getString("result");
    }

    @Given("User should have project opened")
    public void openNewProject(String newProjectId){
        toAuthorize();
        RestAssured.get("http://localhost/board/" + newProjectId);
        refresh();
    }
}
