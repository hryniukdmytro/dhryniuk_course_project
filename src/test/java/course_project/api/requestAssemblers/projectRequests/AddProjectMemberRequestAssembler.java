package course_project.api.requestAssemblers.projectRequests;

import course_project.api.requestElements.genericRequestData.GenericData;
import course_project.api.requestElements.projectPermissionsRequestParams.ProjectPermissionParamsData;
import org.json.JSONObject;

import static course_project.api.methods.ProjectMethods.METHOD_ADD_PROJECT_USER;
import static course_project.api.projectRoles.ProjectRoles.ROLE_PROJECT_MEMBER;

public class AddProjectMemberRequestAssembler {
    public static JSONObject assembleAddProjectMemberRequest(String projectId) {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_ADD_PROJECT_USER)
                .build();

        ProjectPermissionParamsData projectPermissionParams = ProjectPermissionParamsData
                .builder()
                .project_id(Integer.parseInt(projectId))
                .role(ROLE_PROJECT_MEMBER)
                .build();
        JSONObject addProjectRequestBody = new JSONObject(genericData);
        JSONObject addProjectRequestParams = new JSONObject(projectPermissionParams);

        addProjectRequestBody.put("params", addProjectRequestParams);

        return addProjectRequestBody;
    }
}
