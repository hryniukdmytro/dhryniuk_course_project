package course_project.api.requestAssemblers;


import course_project.api.requestElements.genericRequestData.GenericData;
import course_project.api.requestElements.userRequestParams.UserParamsData;
import org.json.JSONObject;

import static course_project.api.methods.UserMethods.METHOD_CREATE_USER;
import static course_project.utils.EnvPropertiesSetup.*;

public class CreateUserRequestAssembler {

    public static JSONObject assembleCreateUserRequest() {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_CREATE_USER)
                .build();

        UserParamsData userParamsData = UserParamsData
                .builder()
                .username(TESTDATA_NEW_USER_NAME)
                .password(TESTDATA_NEW_USER_PASSWORD)
                .build();

        JSONObject createUserRequestBody = new JSONObject(genericData);
        JSONObject createUserParams = new JSONObject(userParamsData);

        createUserRequestBody.put("params", createUserParams);

        return createUserRequestBody;
    }
}