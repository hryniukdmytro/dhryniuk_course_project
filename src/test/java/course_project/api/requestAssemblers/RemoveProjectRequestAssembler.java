package course_project.api.requestAssemblers;

import org.json.JSONObject;

import static course_project.api.methods.ProjectMethods.METHOD_REMOVE_PROJECT;

public class RemoveProjectRequestAssembler {
    public static JSONObject removeProjectRequestAssembling(String projectToRemoveId) {
        JSONObject removeProjectRequestBody = new JSONObject();
        removeProjectRequestBody.put("jsonrpc", "2.0");
        removeProjectRequestBody.put("method", METHOD_REMOVE_PROJECT);
        removeProjectRequestBody.put("id", "1792");

        JSONObject removeProjectParams = new JSONObject();
        removeProjectParams.put("project_id", projectToRemoveId);

        removeProjectRequestBody.put("params", removeProjectParams);

        return removeProjectRequestBody;
    }
}
