package course_project.api.requestAssemblers.taskRequests;


import course_project.api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

import static course_project.api.methods.TaskMethods.METHOD_REMOVE_TASK;

public class RemoveTaskRequestAssembler {
    public static JSONObject assembleRemoveTaskRequest(String taskIdToRemove) {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_REMOVE_TASK)
                .build();
        JSONObject removeTaskRequestBody = new JSONObject(genericData);

        JSONObject removeTaskParams = new JSONObject();
        removeTaskParams.put("task_id", taskIdToRemove);

        removeTaskRequestBody.put("params", removeTaskParams);

        return removeTaskRequestBody;
    }

}