package course_project.api.requestAssemblers.userRequests;


import course_project.api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

import static course_project.api.methods.UserMethods.METHOD_REMOVE_USER;

public class RemoveUserRequestAssembler {
    public static JSONObject assembleRemoveUserRequest(String userIdToRemove) {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_REMOVE_USER)
                .build();
        JSONObject removeUserRequestBody = new JSONObject(genericData);

        JSONObject removeUserParams = new JSONObject();
        removeUserParams.put("user_id", userIdToRemove);

        removeUserRequestBody.put("params", removeUserParams);

        return removeUserRequestBody;
    }
}