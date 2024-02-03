package course_project.api.requestAssemblers.taskRequests;

import course_project.api.methods.TaskMethods;
import course_project.api.requestElements.genericRequestData.GenericData;
import course_project.api.requestElements.taskRequestParams.TaskParamsData;
import org.json.JSONObject;

public class CreateTaskRequestAssembler {
    public static JSONObject assembleCreateTaskRequest(String projectId, String taskTitle) {
        GenericData genericData = GenericData
                .builder()
                .method(TaskMethods.CREATE_TASK.getMethodName())
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
