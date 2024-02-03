package course_project.api.requestAssemblers.projectRequests;

import course_project.api.methods.ProjectMethods;
import course_project.api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

public class GetAllProjectsRequestAssembler {
    public static JSONObject assembleGetAllProjectRequest() {
        GenericData genericData = GenericData
                .builder()
                .method(ProjectMethods.GET_ALL_PROJECTS.getMethodName())
                .build();
        return new JSONObject(genericData);
    }
}