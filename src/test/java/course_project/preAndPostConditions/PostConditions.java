package course_project.preAndPostConditions;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;

import java.util.List;

import static api.queries.QueryFormats.deleteRequest;
import static api.queries.QueryFormats.getRequest;
import static api.requestAssemblers.projectRequests.GetAllProjectsRequestAssembler.assembleGetAllProjectRequest;
import static api.requestAssemblers.projectRequests.RemoveProjectRequestAssembler.assembleRemoveProjectRequest;
import static setup.EnvAuthAndCookiesSetup.*;

public class PostConditions {
    @Given("All projects should be removed")
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
