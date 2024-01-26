package course_project.api.requestAssemblers.userRequests;


import course_project.api.requestElements.genericRequestData.GenericData;
import course_project.api.requestElements.userRequestParams.UserParamsData;
import org.json.JSONObject;

import static course_project.api.methods.UserMethods.METHOD_CREATE_USER;
import static course_project.envPropertiesSetup.EnvTestDataSetup.TESTDATA_NEW_USER_PASSWORD;
import static course_project.envPropertiesSetup.EnvTestDataSetup.TESTDATA_NEW_USER_NAME;

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