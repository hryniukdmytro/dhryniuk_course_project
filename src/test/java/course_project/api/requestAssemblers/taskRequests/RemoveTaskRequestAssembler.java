package course_project.api.requestAssemblers.taskRequests;


import course_project.api.methods.TaskMethods;
import course_project.api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

public class RemoveTaskRequestAssembler {
    public static JSONObject assembleRemoveTaskRequest(String taskIdToRemove) {
        GenericData genericData = GenericData
                .builder()
                .method(TaskMethods.REMOVE_TASK.getMethodName())
                .build();
        JSONObject removeTaskRequestBody = new JSONObject(genericData);
        JSONObject removeTaskParams = new JSONObject();
        removeTaskParams.put("task_id", taskIdToRemove);
        removeTaskRequestBody.put("params", removeTaskParams);
        return removeTaskRequestBody;
    }
}