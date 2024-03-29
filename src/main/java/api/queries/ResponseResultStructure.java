package api.queries;

import lombok.Getter;

@Getter
public enum ResponseResultStructure {
    RESULT("result"),
    RESULT_NAME("result.name"),
    RESULT_USERNAME("result.username"),
    RESULT_TITLE("result.title");

    private final String responseResultElement;

    ResponseResultStructure(String responseResultElement) {
        this.responseResultElement = responseResultElement;
    }
}
