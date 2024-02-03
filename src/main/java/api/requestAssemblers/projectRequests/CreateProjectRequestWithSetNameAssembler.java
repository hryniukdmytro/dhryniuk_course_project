package api.requestAssemblers.projectRequests;

import api.methods.ProjectMethods;
import api.requestElements.genericRequestData.GenericData;
import api.requestElements.projectRequestParams.ProjectParamsData;
import org.json.JSONObject;

public class CreateProjectRequestWithSetNameAssembler {
    public static JSONObject assembleCreateProjectWithSetNameRequest(String desiredProjectName) {
        GenericData genericData = GenericData
                .builder()
                .method(ProjectMethods.CREATE_PROJECT.getMethodName())
                .build();
        ProjectParamsData projectParams = ProjectParamsData
                .builder()
                .name(desiredProjectName)
                .build();
        JSONObject createProjectRequestBody = new JSONObject(genericData);
        JSONObject createProjectParams = new JSONObject(projectParams);
        createProjectRequestBody.put("params", createProjectParams);
        return createProjectRequestBody;
    }
}
