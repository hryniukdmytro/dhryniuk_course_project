package api.requestAssemblers.projectRequests;

import api.methods.ProjectMethods;
import api.projectRoles.ProjectRoles;
import api.requestElements.genericRequestData.GenericData;
import api.requestElements.projectPermissionsRequestParams.ProjectPermissionParamsData;
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
