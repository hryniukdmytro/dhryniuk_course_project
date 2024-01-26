package course_project.api.requestAssemblers.taskRequests;

import course_project.api.requestElements.genericRequestData.GenericData;
import course_project.api.requestElements.taskRequestParams.TaskParamsData;
import org.json.JSONObject;

import static course_project.api.methods.TaskMethods.METHOD_CREATE_TASK;
import static course_project.envPropertiesSetup.EnvTestDataSetup.TESTDATA_TASK_TITLE;

public class CreateTaskRequestAssembler {

    public static JSONObject assembleCreateTaskRequest(String projectId) {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_CREATE_TASK)
                .build();

        TaskParamsData taskParams = TaskParamsData
                .builder()
                .title(TESTDATA_TASK_TITLE)
                .project_id(Integer.parseInt(projectId))
                .build();

        JSONObject createTaskRequestBody = new JSONObject(genericData);
        JSONObject createTaskParams = new JSONObject(taskParams);

        createTaskRequestBody.put("params", createTaskParams);

        return createTaskRequestBody;
    }
}
