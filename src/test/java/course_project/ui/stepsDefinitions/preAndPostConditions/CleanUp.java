package course_project.ui.stepsDefinitions.preAndPostConditions;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import java.util.List;

import static course_project.api.queries.QueryFormats.deleteRequest;
import static course_project.api.queries.QueryFormats.getRequest;
import static course_project.api.requestAssemblers.GetAllProjectsRequestAssembler.getAllProjectRequestAssembler;
import static course_project.api.requestAssemblers.RemoveProjectRequestAssembler.removeProjectRequestAssembling;
import static course_project.utils.EnvPropertiesSetup.*;

public class CleanUp {

    @Given("Remove all projects")
    public void removeAllProjects() {
        authConstantsSetup();

        Response getAllProjectsResponse = getRequest(API_USERNAME, API_TOKEN,
                getAllProjectRequestAssembler().toString());
        getAllProjectsResponse.then().statusCode(200);

        List<Integer> projectIds = getAllProjectsResponse.jsonPath().getList("result.id");

        for (Integer projectId : projectIds) {
            Response removeAllProjectsResponse = deleteRequest(API_USERNAME, API_TOKEN,
                    removeProjectRequestAssembling(String.valueOf(projectId)).toString());
            removeAllProjectsResponse.then().statusCode(200);
        }
    }
}
