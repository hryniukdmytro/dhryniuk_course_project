package api.requestAssemblers.projectRequests;

import api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

import static api.methods.ProjectMethods.METHOD_GET_ALL_PROJECTS;

public class GetAllProjectsRequestAssembler {

    public static JSONObject assembleGetAllProjectRequest() {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_GET_ALL_PROJECTS)
                .build();

        return new JSONObject(genericData);
    }
}