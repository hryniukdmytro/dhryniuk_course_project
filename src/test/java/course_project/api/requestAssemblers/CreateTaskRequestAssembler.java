package course_project.api.requestAssemblers;

import course_project.api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

import static course_project.api.methods.TaskMethods.METHOD_CREATE_TASK;

public class CreateTaskRequestAssembler {

    public static JSONObject createTaskRequestAssembling(String projectId) {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_CREATE_TASK)
                .build();
        JSONObject createTaskRequestBody = new JSONObject(genericData);

        JSONObject createTaskParams = new JSONObject();
        createTaskParams.put("title", "Test Task");
        createTaskParams.put("project_id", projectId);

        createTaskRequestBody.put("params", createTaskParams);

        return createTaskRequestBody;
    }

}
