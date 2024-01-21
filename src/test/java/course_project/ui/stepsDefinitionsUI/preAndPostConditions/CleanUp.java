package course_project.ui.stepsDefinitionsUI.preAndPostConditions;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import java.util.List;

import static course_project.api.queries.QueryFormats.deleteRequest;
import static course_project.api.queries.QueryFormats.getRequest;
import static course_project.api.requestAssemblers.GetAllProjectsRequestAssembler.assembleGetAllProjectRequest;
import static course_project.api.requestAssemblers.RemoveProjectRequestAssembler.assembleRemoveProjectRequest;
import static course_project.utils.EnvPropertiesSetup.*;

public class CleanUp {

    @Given("Remove all projects")
    public void removeAllProjects() {
        authConstantsSetup();

        Response getAllProjectsResponse = getRequest(API_USERNAME, API_TOKEN,
                assembleGetAllProjectRequest().toString());
        getAllProjectsResponse.then().statusCode(200);

        List<Integer> projectIds = getAllProjectsResponse.jsonPath().getList("result.id");

        for (Integer projectId : projectIds) {
            Response removeAllProjectsResponse = deleteRequest(API_USERNAME, API_TOKEN,
                    assembleRemoveProjectRequest(String.valueOf(projectId)).toString());
            removeAllProjectsResponse.then().statusCode(200);
        }
    }
}