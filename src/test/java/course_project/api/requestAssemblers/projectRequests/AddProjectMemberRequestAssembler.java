package course_project.api.requestAssemblers.projectRequests;

import course_project.api.methods.ProjectMethods;
import course_project.api.projectRoles.ProjectRoles;
import course_project.api.requestElements.genericRequestData.GenericData;
import course_project.api.requestElements.projectPermissionsRequestParams.ProjectPermissionParamsData;
import org.json.JSONObject;

public class AddProjectMemberRequestAssembler {
    public static JSONObject assembleAddProjectMemberRequest(String projectId) {
        GenericData genericData = GenericData
                .builder()
                .method(ProjectMethods.ADD_PROJECT_USER.getMethodName())
                .build();
        ProjectPermissionParamsData projectPermissionParams = ProjectPermissionParamsData
                .builder()
                .project_id(Integer.parseInt(projectId))
                .role(ProjectRoles.PROJECT_MEMBER.getRoleName())
                .build();
        JSONObject addProjectRequestBody = new JSONObject(genericData);
        JSONObject addProjectRequestParams = new JSONObject(projectPermissionParams);
        addProjectRequestBody.put("params", addProjectRequestParams);
        return addProjectRequestBody;
    }
}
