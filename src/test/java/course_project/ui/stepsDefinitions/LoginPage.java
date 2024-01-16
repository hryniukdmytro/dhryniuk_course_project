package course_project.ui.stepsDefinitions;

import course_project.ui.elements.LoginPageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends LoginPageElements {

    @Given("Navigate to login page in browser")
    public void openLoginPage() {
        open("http://localhost");
    }

    @When("Enter 'admin' as a username and 'admin' as a password")
    public void enterValidCredentials() {
        loginTextField().shouldBe(visible);
        passwordTextField().shouldBe(visible);
        loginButton().shouldBe(visible);
        loginTextField().sendKeys("admin");
        passwordTextField().sendKeys("admin");
    }

    @When("Enter invalid username {} and password {}")
    public void enterInvalidUsernameAndPassword(String username, String password) {
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
    public void mainPageShouldNotBeDisplayedAfterUnsuccessfulLogin() {
        Assert.assertTrue(badCredsErrorMessage().isDisplayed());
    }
}
