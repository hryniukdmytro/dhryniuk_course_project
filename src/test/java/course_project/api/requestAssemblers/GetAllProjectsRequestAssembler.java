package course_project.api.requestAssemblers;

import org.json.JSONObject;

import static course_project.api.methods.ProjectMethods.METHOD_GET_ALL_PROJECTS;

public class GetAllProjectsRequestAssembler {

    public static JSONObject getAllProjectRequestAssembler() {
     JSONObject getAllProjectsRequestBody = new JSONObject();
        getAllProjectsRequestBody.put("jsonrpc", "2.0");
        getAllProjectsRequestBody.put("method", METHOD_GET_ALL_PROJECTS);
        getAllProjectsRequestBody.put("id", "1792");

        return getAllProjectsRequestBody;
    }
}