package course_project.api.requestAssemblers.projectRequests;

import course_project.api.requestElements.genericRequestData.GenericData;
import course_project.api.requestElements.projectRequestParams.ProjectParamsData;
import org.json.JSONObject;

import static course_project.api.methods.ProjectMethods.METHOD_CREATE_PROJECT;
import static course_project.envPropertiesSetup.EnvTestDataSetup.TESTDATA_PROJECT_NAME;

public class CreateProjectRequestAssembler {

    public static JSONObject assembleCreateProjectRequest() {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_CREATE_PROJECT)
                .build();

        ProjectParamsData projectParams = ProjectParamsData
                .builder()
                .name(TESTDATA_PROJECT_NAME)
                .build();

        JSONObject createProjectRequestBody = new JSONObject(genericData);
        JSONObject createProjectParams = new JSONObject(projectParams);

        createProjectRequestBody.put("params", createProjectParams);

        return createProjectRequestBody;
    }
}
