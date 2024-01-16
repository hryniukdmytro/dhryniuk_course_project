package course_project.ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageElements {
    public SelenideElement loginTextField() {
        return $("[id='form-username']");
    }

    public SelenideElement passwordTextField() {
        return $("[id='form-password']");
    }

    public SelenideElement loginButton() {
        return $("[type=submit]");
    }

    public SelenideElement badCredsErrorMessage() {
        return $("[class='alert alert-error']");
    }
}
