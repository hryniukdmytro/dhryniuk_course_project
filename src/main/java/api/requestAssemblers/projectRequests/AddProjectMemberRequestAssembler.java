package api.requestAssemblers.projectRequests;

import api.projectRoles.ProjectRoles;
import api.requestElements.projectPermissionsRequestParams.ProjectPermissionParamsData;
import api.requestElements.genericRequestData.GenericData;
import org.json.JSONObject;

import static api.methods.ProjectMethods.METHOD_ADD_PROJECT_USER;

public class AddProjectMemberRequestAssembler {
    public static JSONObject assembleAddProjectMemberRequest(String projectId) {
        GenericData genericData = GenericData
                .builder()
                .method(METHOD_ADD_PROJECT_USER)
                .build();

        ProjectPermissionParamsData projectPermissionParams = ProjectPermissionParamsData
                .builder()
                .project_id(Integer.parseInt(projectId))
                .role(ProjectRoles.ROLE_PROJECT_MEMBER)
                .build();
        JSONObject addProjectRequestBody = new JSONObject(genericData);
        JSONObject addProjectRequestParams = new JSONObject(projectPermissionParams);

        addProjectRequestBody.put("params", addProjectRequestParams);

        return addProjectRequestBody;
    }
}
