package course_project.api.requestAssemblers.userRequests;

import course_project.api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

import static course_project.api.methods.UserMethods.METHOD_GET_USER;

public class GetUserRequestAssembler {
    public static JSONObject assembleGetUserRequest(String userIdToGet) {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_GET_USER)
                .build();
        JSONObject getUserRequestBody = new JSONObject(genericData);

        JSONObject getUserParams = new JSONObject();
        getUserParams.put("user_id", userIdToGet);

        getUserRequestBody.put("params", getUserParams);

        return getUserRequestBody;
    }
}