package course_project.ui.stepsDefinitions;

import com.codeborne.selenide.WebDriverRunner;
import course_project.ui.elements.MainPageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class MainPage extends MainPageElements {

    @When("Main page should be displayed after successful login")
    public void isMainPageDisplayed() {
        Assert.assertTrue(mainPageBody().isDisplayed());
    }


    @Given("User should be logged in")
    public void createUserSession() {
        open("http://localhost");
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("KB_SID", "du4mo4faq8ohe0b51qv5ri530q"));
        refresh();
    }
}
