package course_project.api.requestElements.projectPermissionsRequestParams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectPermissionParamsData {
    @Builder.Default
    private int user_id = 1;
    private int project_id;
    private String role;
}
