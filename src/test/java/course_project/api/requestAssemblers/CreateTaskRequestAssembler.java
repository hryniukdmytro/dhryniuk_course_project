package course_project.api.requestAssemblers;

import org.json.JSONObject;

import static course_project.api.methods.TaskMethods.METHOD_CREATE_TASK;

public class CreateTaskRequestAssembler {

    public static JSONObject createTaskRequestAssembling(String projectId) {
        JSONObject createTaskRequestBody = new JSONObject();
        createTaskRequestBody.put("jsonrpc", "2.0");
        createTaskRequestBody.put("method", METHOD_CREATE_TASK);
        createTaskRequestBody.put("id", "1792");

        JSONObject createTaskParams = new JSONObject();
        createTaskParams.put("title", "Test Task");
        createTaskParams.put("project_id", projectId);

        createTaskRequestBody.put("params", createTaskParams);

        return createTaskRequestBody;
    }

}
