package course_project.api.methods;

import lombok.Getter;

@Getter
public enum ProjectMethods {
    GET_ALL_PROJECTS("getAllProjects"),
    GET_PROJECT_BY_ID("getProjectById"),
    CREATE_PROJECT("createProject"),
    REMOVE_PROJECT("removeProject"),
    ADD_PROJECT_USER("addProjectUser");

    private final String methodName;

    ProjectMethods(String methodName) {
        this.methodName = methodName;
    }
}
