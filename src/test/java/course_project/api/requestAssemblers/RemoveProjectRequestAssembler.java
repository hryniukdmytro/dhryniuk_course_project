package course_project.api.requestAssemblers;

import course_project.api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

import static course_project.api.methods.ProjectMethods.METHOD_REMOVE_PROJECT;

public class RemoveProjectRequestAssembler {

    public static JSONObject removeProjectRequestAssembling(String projectToRemoveId) {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_REMOVE_PROJECT)
                .build();
        JSONObject removeProjectRequestBody = new JSONObject(genericData);

        JSONObject removeProjectParams = new JSONObject();
        removeProjectParams.put("project_id", projectToRemoveId);

        removeProjectRequestBody.put("params", removeProjectParams);

        return removeProjectRequestBody;
    }
}
