package api.requestAssemblers.userRequests;

import api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

import static api.methods.UserMethods.METHOD_GET_USER;

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