package api.requestAssemblers.userRequests;


import api.methods.UserMethods;
import api.requestElements.genericRequestData.GenericData;
import api.requestElements.userRequestParams.UserParamsData;
import envPropertiesSetup.EnvTestDataSetup;
import org.json.JSONObject;

public class CreateUserRequestAssembler {
    public static JSONObject assembleCreateUserRequest() {
        GenericData genericData = GenericData
                .builder()
                .method(UserMethods.CREATE_USER.getMethodName())
                .build();
        UserParamsData userParams = UserParamsData
                .builder()
                .username(EnvTestDataSetup.TESTDATA_NEW_USER_NAME)
                .password(EnvTestDataSetup.TESTDATA_NEW_USER_PASSWORD)
                .build();
        JSONObject createUserRequestBody = new JSONObject(genericData);
        JSONObject createUserParams = new JSONObject(userParams);
        createUserRequestBody.put("params", createUserParams);
        return createUserRequestBody;
    }
}