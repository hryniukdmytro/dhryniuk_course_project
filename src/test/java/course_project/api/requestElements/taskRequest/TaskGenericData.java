package course_project.api.requestElements.taskRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskGenericData {
        private double jsonRPC = 2.0;
        private String method;
        private long id;
}
