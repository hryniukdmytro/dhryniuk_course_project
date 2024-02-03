package api.requestAssemblers.taskRequests;


import api.requestElements.genericRequestData.GenericData;
import api.methods.TaskMethods;
import org.json.JSONObject;

public class GetTaskRequestAssembler {
    public static JSONObject assembleGetTaskRequest(String taskIdToGet) {
        GenericData genericData = GenericData
                .builder()
                .method(TaskMethods.GET_TASK.getMethodName())
                .build();
        JSONObject getTaskRequestBody = new JSONObject(genericData);
        JSONObject getTaskParams = new JSONObject();
        getTaskParams.put("task_id", taskIdToGet);
        getTaskRequestBody.put("params", getTaskParams);
        return getTaskRequestBody;
    }
}