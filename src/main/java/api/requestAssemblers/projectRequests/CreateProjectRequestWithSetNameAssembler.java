package api.requestAssemblers.projectRequests;

import api.requestElements.projectRequestParams.ProjectParamsData;
import api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

import static api.methods.ProjectMethods.METHOD_CREATE_PROJECT;


public class CreateProjectRequestWithSetNameAssembler {

    public static JSONObject assembleCreateProjectWithSetNameRequest(String desiredProjectName) {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_CREATE_PROJECT)
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
