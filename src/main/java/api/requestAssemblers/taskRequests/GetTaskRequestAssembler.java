package api.requestAssemblers.taskRequests;


import api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

import static api.methods.TaskMethods.METHOD_GET_TASK;


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