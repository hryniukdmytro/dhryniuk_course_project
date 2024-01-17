package course_project.ui.stepsDefinitions;

import com.codeborne.selenide.WebDriverRunner;
import course_project.ui.elements.MainPageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static course_project.utils.EnvPropertiesSetup.*;

public class MainPageSteps extends MainPageElements {

    @When("Main page should be displayed after successful login")
    public void isMainPageDisplayed() {
        Assert.assertTrue(mainPageBody().isDisplayed());
    }


    @Given("User should be logged in")
    public void createUserSession() {
        open(BASE_URL);
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie(COOKIE_NAME, COOKIE_VALUE));
        refresh();
    }
}
