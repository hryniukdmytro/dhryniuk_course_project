package course_project.api.requestAssemblers.userRequests;

import course_project.api.methods.UserMethods;
import course_project.api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

public class GetUserRequestAssembler {
    public static JSONObject assembleGetUserRequest(String userIdToGet) {
        GenericData genericData = GenericData
                .builder()
                .method(UserMethods.GET_USER.getMethodName())
                .build();
        JSONObject getUserRequestBody = new JSONObject(genericData);
        JSONObject getUserParams = new JSONObject();
        getUserParams.put("user_id", userIdToGet);
        getUserRequestBody.put("params", getUserParams);
        return getUserRequestBody;
    }
}