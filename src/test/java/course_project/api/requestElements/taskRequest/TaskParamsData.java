package course_project.api.requestElements.taskRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskParamsData {
    private int ownerId;
    private int projectId;
}
