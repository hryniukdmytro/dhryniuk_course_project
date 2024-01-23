package course_project.api.requestElements.projectRequestParams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectParamsData {
    @Builder.Default
    private int owner_id = 1;
    private String name;
}
