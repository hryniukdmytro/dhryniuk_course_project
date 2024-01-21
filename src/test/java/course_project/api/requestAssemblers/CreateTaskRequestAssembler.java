package course_project.api.requestAssemblers;

import course_project.api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

import static course_project.api.methods.TaskMethods.METHOD_CREATE_TASK;
import static course_project.utils.EnvPropertiesSetup.TESTDATA_TASK_TITLE;

public class CreateTaskRequestAssembler {

    public static JSONObject assembleCreateTaskRequest(String projectId) {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_CREATE_TASK)
                .build();
        JSONObject createTaskRequestBody = new JSONObject(genericData);

        JSONObject createTaskParams = new JSONObject();
        createTaskParams.put("title", TESTDATA_TASK_TITLE);
        createTaskParams.put("project_id", projectId);

        createTaskRequestBody.put("params", createTaskParams);

        return createTaskRequestBody;
    }

}
