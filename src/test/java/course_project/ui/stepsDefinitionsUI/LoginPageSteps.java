package course_project.ui.stepsDefinitionsUI;

import course_project.ui.elements.LoginPageElements;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static course_project.envPropertiesSetup.EnvTestDataSetup.TESTDATA_LOGIN;
import static course_project.envPropertiesSetup.EnvTestDataSetup.TESTDATA_PASSWORD;

public class LoginPageSteps extends LoginPageElements {

    @When("Enter valid credentials")
    public void enterValidCredentials() {
        loginTextField().shouldBe(visible);
        passwordTextField().shouldBe(visible);
        loginButton().shouldBe(visible);
        loginTextField().sendKeys(TESTDATA_LOGIN);
        passwordTextField().sendKeys(TESTDATA_PASSWORD);
    }

    @When("Enter invalid username {} and password {}")
    public void enterInvalidCredentials(String username, String password) {
        loginTextField().shouldBe(visible);
        passwordTextField().shouldBe(visible);
        loginButton().shouldBe(visible);

        loginTextField().sendKeys(username);
        passwordTextField().sendKeys(password);
    }

    @When("Click on login button")
    public void clickOnLoginButton() {
        loginButton().click();
    }

    @Then("Error message should be displayed after unsuccessful login")
    public void isErrorMessageDisplayedWhenLoginFails() {
        Assert.assertTrue(badCredsErrorMessage().isDisplayed());
    }
}
