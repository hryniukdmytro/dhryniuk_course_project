package course_project.ui.stepsDefinitionsUI.preAndPostConditions;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static course_project.api.stepsDefinitionsAPI.ProjectSteps.newProjectId;
import static course_project.api.stepsDefinitionsAPI.TaskSteps.newTaskId;
import static course_project.envPropertiesSetup.EnvAuthAndCookiesSetup.*;
import static course_project.envPropertiesSetup.EnvCookiesSetup.COOKIE_NAME;
import static course_project.envPropertiesSetup.EnvCookiesSetup.COOKIE_VALUE;

public class PreConditions {

    @Given("Login page should be opened")
    public void openLoginPage() {
        open("http://localhost");
    }

    @Given("User should have project opened")
    public void openNewProject() {
        Selenide.open(BASE_URL + "/board/" + newProjectId);
        Selenide.refresh();
    }

    @Given("User should have last created task opened")
    public void openNewTask() {
        Selenide.open(BASE_URL + "/task/" + newTaskId);
        Selenide.refresh();
    }

    @Given("User should be logged in")
    public void createUserSession() {
        open(BASE_URL);
        getWebDriver().manage().addCookie(new Cookie(COOKIE_NAME, COOKIE_VALUE));
        getWebDriver().manage().window().maximize();
        refresh();
    }
}
