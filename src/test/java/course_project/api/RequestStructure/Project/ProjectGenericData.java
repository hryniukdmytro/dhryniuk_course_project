package course_project.api.RequestStructure.Project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectGenericData {
    private final double jsonRPC = 2.0;
    private String method;
    private long id;
}
