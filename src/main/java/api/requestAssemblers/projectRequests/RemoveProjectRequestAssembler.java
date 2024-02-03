package api.requestAssemblers.projectRequests;

import api.methods.ProjectMethods;
import api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

public class RemoveProjectRequestAssembler {
    public static JSONObject assembleRemoveProjectRequest(String projectIdToRemove) {
        GenericData genericData = GenericData
                .builder()
                .method(ProjectMethods.REMOVE_PROJECT.getMethodName())
                .build();
        JSONObject removeProjectRequestBody = new JSONObject(genericData);
        JSONObject removeProjectParams = new JSONObject();
        removeProjectParams.put("project_id", projectIdToRemove);
        removeProjectRequestBody.put("params", removeProjectParams);
        return removeProjectRequestBody;
    }
}
