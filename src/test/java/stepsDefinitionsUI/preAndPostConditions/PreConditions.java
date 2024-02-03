package stepsDefinitionsUI.preAndPostConditions;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static stepsDefinitionsAPI.ProjectSteps.newProjectId;
import static stepsDefinitionsAPI.TaskSteps.newTaskId;
import static envPropertiesSetup.EnvAuthAndCookiesSetup.*;
import static envPropertiesSetup.EnvCookiesSetup.COOKIE_NAME;
import static envPropertiesSetup.EnvCookiesSetup.COOKIE_VALUE;

public class PreConditions {
    @Given("Login page should be opened")
    public void openLoginPage() {
        open(BASE_URL);
        getWebDriver().manage().window().maximize();

    }

    @Given("User should have project opened")
    public void openNewProject() {
        Selenide.open(BASE_URL + "/board/" + newProjectId);
        getWebDriver().manage().window().maximize();
        Selenide.refresh();
    }

    @Given("User should have last created task opened")
    public void openNewTask() {
        Selenide.open(BASE_URL + "/task/" + newTaskId);
        Selenide.refresh();
        getWebDriver().manage().window().maximize();
    }

    @Given("User should be logged in")
    public void createUserSession() {
        open(BASE_URL);
        getWebDriver().manage().addCookie(new Cookie(COOKIE_NAME, COOKIE_VALUE));
        getWebDriver().manage().window().maximize();
        refresh();
    }
}
