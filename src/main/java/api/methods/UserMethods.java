package api.methods;

import lombok.Getter;

@Getter
public enum UserMethods {
    CREATE_USER("createUser"),
    GET_USER("getUser"),
    REMOVE_USER("removeUser");

    private final String methodName;

    UserMethods(String methodName) {
        this.methodName = methodName;
    }
}
