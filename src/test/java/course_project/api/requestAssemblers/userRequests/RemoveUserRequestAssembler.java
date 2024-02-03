package course_project.api.requestAssemblers.userRequests;


import course_project.api.methods.UserMethods;
import course_project.api.requestElements.genericRequestData.GenericData;
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