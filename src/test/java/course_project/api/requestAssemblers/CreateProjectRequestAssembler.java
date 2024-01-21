package course_project.api.requestAssemblers;

import course_project.api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

import static course_project.api.methods.ProjectMethods.METHOD_CREATE_PROJECT;
import static course_project.utils.EnvPropertiesSetup.TESTDATA_PROJECT_NAME;

public class CreateProjectRequestAssembler {

    public static JSONObject assembleCreateProjectRequest() {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_CREATE_PROJECT)
                .build();
        JSONObject createProjectRequestBody = new JSONObject(genericData);

        JSONObject createProjectParams = new JSONObject();
        createProjectParams.put("name", TESTDATA_PROJECT_NAME);
        createProjectParams.put("owner_id", "1");

        createProjectRequestBody.put("params", createProjectParams);

        return createProjectRequestBody;
    }
}
