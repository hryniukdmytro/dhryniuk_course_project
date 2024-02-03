package course_project.api.methods;

import lombok.Getter;

@Getter
public enum TaskMethods {
    GET_TASK("getTask"),
    CREATE_TASK("createTask"),
    REMOVE_TASK("removeTask");

    private final String methodName;

    TaskMethods(String methodName) {
        this.methodName = methodName;
    }
}
