package api.requestAssemblers.projectRequests;

import api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

import static api.methods.ProjectMethods.METHOD_GET_PROJECT_BY_ID;

public class GetProjectByIdRequestAssembler {
    public static JSONObject assembleGetProjectByIdRequest(String projectIdToGet) {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_GET_PROJECT_BY_ID)
                .build();
        JSONObject getProjectRequestBody = new JSONObject(genericData);

        JSONObject getProjectParams = new JSONObject();
        getProjectParams.put("project_id", projectIdToGet);

        getProjectRequestBody.put("params", getProjectParams);

        return getProjectRequestBody;
    }

}