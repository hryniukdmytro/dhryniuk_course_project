package course_project.api.requestAssemblers;

import course_project.api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

import static course_project.api.methods.ProjectMethods.METHOD_GET_ALL_PROJECTS;

public class GetAllProjectsRequestAssembler {

    public static JSONObject getAllProjectRequestAssembler() {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_GET_ALL_PROJECTS)
                .build();

        return new JSONObject(genericData);
    }
}