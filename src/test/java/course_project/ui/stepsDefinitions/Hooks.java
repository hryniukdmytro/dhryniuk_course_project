package course_project.ui.stepsDefinitions;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;


public class Hooks {

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
