package course_project.api.requestAssemblers.taskRequests;


import course_project.api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

import static course_project.api.methods.TaskMethods.METHOD_GET_TASK;

public class GetTaskRequestAssembler {
    public static JSONObject assembleGetTaskRequest(String taskIdToGet) {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_GET_TASK)
                .build();
        JSONObject getTaskRequestBody = new JSONObject(genericData);

        JSONObject getTaskParams = new JSONObject();
        getTaskParams.put("task_id", taskIdToGet);

        getTaskRequestBody.put("params", getTaskParams);

        return getTaskRequestBody;
    }

}