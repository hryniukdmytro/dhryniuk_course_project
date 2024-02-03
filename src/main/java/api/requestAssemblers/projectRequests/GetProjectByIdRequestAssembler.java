package api.requestAssemblers.projectRequests;

import api.requestElements.genericRequestData.GenericData;
import api.methods.ProjectMethods;
import org.json.JSONObject;

public class GetProjectByIdRequestAssembler {
    public static JSONObject assembleGetProjectByIdRequest(String projectIdToGet) {
        GenericData genericData = GenericData
                .builder()
                .method(ProjectMethods.GET_PROJECT_BY_ID.getMethodName())
                .build();
        JSONObject getProjectRequestBody = new JSONObject(genericData);
        JSONObject getProjectParams = new JSONObject();
        getProjectParams.put("project_id", projectIdToGet);
        getProjectRequestBody.put("params", getProjectParams);
        return getProjectRequestBody;
    }
}