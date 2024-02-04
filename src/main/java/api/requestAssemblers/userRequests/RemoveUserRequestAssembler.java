package api.requestAssemblers.userRequests;

import api.requestElements.genericRequestData.GenericData;
import api.methods.UserMethods;
import org.json.JSONObject;

public class RemoveUserRequestAssembler {
    public static JSONObject assembleRemoveUserRequest(String userIdToRemove) {
        GenericData genericData = GenericData
                .builder()
                .method(UserMethods.REMOVE_USER.getMethodName())
                .build();
        JSONObject removeUserRequestBody = new JSONObject(genericData);
        JSONObject removeUserParams = new JSONObject();
        removeUserParams.put("user_id", userIdToRemove);
        removeUserRequestBody.put("params", removeUserParams);
        return removeUserRequestBody;
    }
}