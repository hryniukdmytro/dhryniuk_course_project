package api.projectRoles;

import lombok.Getter;

@Getter
public enum ProjectRoles {
    PROJECT_MEMBER("project-member");

    private final String roleName;

    ProjectRoles(String roleName) {
        this.roleName = roleName;
    }
}
