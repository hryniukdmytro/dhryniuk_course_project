package api.requestAssemblers.projectRequests;

import api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

import static api.methods.ProjectMethods.METHOD_REMOVE_PROJECT;

public class RemoveProjectRequestAssembler {

    public static JSONObject assembleRemoveProjectRequest(String projectIdToRemove) {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_REMOVE_PROJECT)
                .build();
        JSONObject removeProjectRequestBody = new JSONObject(genericData);

        JSONObject removeProjectParams = new JSONObject();
        removeProjectParams.put("project_id", projectIdToRemove);

        removeProjectRequestBody.put("params", removeProjectParams);

        return removeProjectRequestBody;
    }
}
