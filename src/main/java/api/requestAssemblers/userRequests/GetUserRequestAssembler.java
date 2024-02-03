package api.requestAssemblers.userRequests;

import api.methods.UserMethods;
import api.requestElements.genericRequestData.GenericData;
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