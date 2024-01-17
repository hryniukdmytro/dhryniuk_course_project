package course_project.api.requestAssemblers;

import org.json.JSONObject;

import static course_project.api.methods.ProjectMethods.METHOD_CREATE_PROJECT;

public class CreateProjectRequestAssembler {

    public static JSONObject createProjectRequestAssembling() {
        JSONObject createProjectRequestBody = new JSONObject();
        createProjectRequestBody.put("jsonrpc", "2.0");
        createProjectRequestBody.put("method", METHOD_CREATE_PROJECT);
        createProjectRequestBody.put("id", "1792");

        JSONObject createProjectParams = new JSONObject();
        createProjectParams.put("name", "Test Project");
        createProjectParams.put("owner_id", "1");

        createProjectRequestBody.put("params", createProjectParams);

        return createProjectRequestBody;
    }
}
