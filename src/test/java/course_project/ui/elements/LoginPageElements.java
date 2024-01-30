package course_project.ui.elements;

import com.codeborne.selenide.SelenideElement;
import course_project.ui.exceptionsHandling.ElementOnPageNotFoundException;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.$;
@Getter
public class LoginPageElements extends BasePage{

    private final SelenideElement loginTextField = $("[id='form-username']");
    private final SelenideElement passwordTextField = $("[id='form-password']");
    private final SelenideElement loginButton = $("[type=submit]");
    private final SelenideElement badCredsErrorMessage = $("[class='alert alert-error']");

    @Override
    public SelenideElement getWebElementByName(String elementName) {
        Map<String, Supplier<SelenideElement>> elements = getElementNamesAndElementGetterMap();
        if (elements.get(elementName) == null) {
            throw new ElementOnPageNotFoundException(elementName, "LoginPage");
        }
        return elements.get(elementName).get();
    }

    private Map<String, Supplier<SelenideElement>> getElementNamesAndElementGetterMap() {
        Map<String, Supplier<SelenideElement>> elements = new HashMap<>();
        elements.put("Login_Button", this::getLoginButton);
        elements.put("Login_Field", this::getLoginTextField);
        elements.put("Password_Field", this::getPasswordTextField);
        elements.put("Bad_Credentials_Error", this::getBadCredsErrorMessage);
        return elements;
    }

}
