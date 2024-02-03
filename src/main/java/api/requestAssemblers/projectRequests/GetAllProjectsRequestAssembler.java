package api.requestAssemblers.projectRequests;

import api.methods.ProjectMethods;
import api.requestElements.genericRequestData.GenericData;
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