package api.requestAssemblers.taskRequests;

import api.requestElements.taskRequestParams.TaskParamsData;
import api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

import static api.methods.TaskMethods.METHOD_CREATE_TASK;

public class CreateTaskRequestAssembler {

    public static JSONObject assembleCreateTaskRequest(String projectId, String taskTitle) {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_CREATE_TASK)
                .build();

        TaskParamsData taskParams = TaskParamsData
                .builder()
                .title(taskTitle)
                .project_id(Integer.parseInt(projectId))
                .build();

        JSONObject createTaskRequestBody = new JSONObject(genericData);
        JSONObject createTaskParams = new JSONObject(taskParams);

        createTaskRequestBody.put("params", createTaskParams);

        return createTaskRequestBody;
    }
}
