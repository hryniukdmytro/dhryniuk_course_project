package api.requestAssemblers.userRequests;


import api.requestElements.genericRequestData.GenericData;
import api.requestElements.userRequestParams.UserParamsData;
import org.json.JSONObject;

import static api.methods.UserMethods.METHOD_CREATE_USER;
import static setup.EnvTestDataSetup.TESTDATA_NEW_USER_PASSWORD;
import static setup.EnvTestDataSetup.TESTDATA_NEW_USER_NAME;

public class CreateUserRequestAssembler {

    public static JSONObject assembleCreateUserRequest() {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_CREATE_USER)
                .build();

        UserParamsData userParams = UserParamsData
                .builder()
                .username(TESTDATA_NEW_USER_NAME)
                .password(TESTDATA_NEW_USER_PASSWORD)
                .build();

        JSONObject createUserRequestBody = new JSONObject(genericData);
        JSONObject createUserParams = new JSONObject(userParams);

        createUserRequestBody.put("params", createUserParams);

        return createUserRequestBody;
    }
}