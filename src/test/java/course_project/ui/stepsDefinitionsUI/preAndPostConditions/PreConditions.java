package course_project.ui.stepsDefinitionsUI.preAndPostConditions;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

import static course_project.api.stepsDefinitionsAPI.ProjectSteps.newProjectId;
import static course_project.api.stepsDefinitionsAPI.TaskSteps.newTaskId;
import static course_project.utils.EnvPropertiesSetup.*;

public class PreConditions {

    @Given("User should have project opened")
    public void openNewProject() {
        Selenide.open(BASE_URL + "/board/" + newProjectId);
        Selenide.refresh();
    }

    @Given("User should have task opened")
    public void openNewTask() {
        Selenide.open(BASE_URL + "/task/" + newTaskId);
        Selenide.refresh();
    }
}
