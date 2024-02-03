package course_project.ui.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import course_project.ui.exceptionsHandling.ElementOnPageNotFoundException;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class ProjectPageElements extends BasePage {
    public SelenideElement selectProjectDropdownOptionByName(String projectNameToSelect) {
        return $("[data-label='" + projectNameToSelect + "']");
    }

    public SelenideElement taskBoardColumn(int boardColumnId) {
        return $("tbody tr:nth-child(2) td:nth-child(" + boardColumnId + ")");
    }

    // Find task on project task board
    public SelenideElement findTaskOnBoard(String taskTitle) {
        return $$(".task-board-title a")
                .find(Condition.exactText(taskTitle));
    }

    // <-------------- Buttons ------------>
    public final SelenideElement saveModalButton = $("button.btn.btn-blue:not(.accordion-content.comments button)");
    public final SelenideElement yesModalButton = $("[id='modal-confirm-button']");
    public final SelenideElement configureThisProjectButton = $(".dropdown-submenu-open [class*='fa-cog']");
    public final SelenideElement closeThisProjectButton = $x("//a[contains(text(),'Close this project')]");
    public final SelenideElement addCommentButton = $(".sidebar [class*='fa-comment-o']");
    public final SelenideElement addNewTaskButton = $(".dropdown-submenu-open [class*='fa-plus']");
    public final SelenideElement closeTaskButton = $("[class='fa fa-times fa-fw js-modal-confirm']");
    public final SelenideElement duplicateToProjectButton = $(".sidebar-icons [class*='fa-clipboard']");
    public final SelenideElement addSubTaskButton = $(".sidebar-icons [class*='fa-plus']");
    public final SelenideElement viewTaskListButton = $("[class='view-listing']");
    // <-------------- Dropdowns ------------>
    public final SelenideElement projectConfigDropdown = $("[class='fa fa-cog']");
    public final SelenideElement selectProjectToCopyToDropdown = $("#modal-content .select-dropdown-input-container");
    // <------ TextFields & TextAreas ------->
    public final SelenideElement projectNameModalTextField = $("[id='form-name']");
    public final SelenideElement formTitleTextField = $("[id=form-title]");
    public final SelenideElement commentModalTextArea = $("#modal-content [name='comment']");
    // <-------------- Other ---------------->
    public final SelenideElement projectTitle = $("[class=title]");
    public final SelenideElement existingTaskTitle = $("[class='table-list-title ']");
    public final SelenideElement existingSubTaskTitle = $("[class='subtask-title']");
    public final SelenideElement addedComment = $("div.markdown > p:nth-child(1)");
    public final SelenideElement taskState = $x("//strong[contains(text(),'Status:')]/following-sibling::span");
    public final SelenideElement projectState = $(".panel:nth-child(2) li:nth-child(1) > strong:nth-child(1)");
    public final SelenideElement linkToDuplicatedTask = $(".task-links-table a[href^='/task/'][title]");

    @Override
    public SelenideElement getWebElementByName(String elementName) {
        Map<String, Supplier<SelenideElement>> elements = getElementNamesAndElementGetterMap();
        if (elements.get(elementName) == null) {
            throw new ElementOnPageNotFoundException(elementName, "ProjectPage");
        }
        return elements.get(elementName).get();
    }

    private Map<String, Supplier<SelenideElement>> getElementNamesAndElementGetterMap() {
        Map<String, Supplier<SelenideElement>> elements = new HashMap<>();
        // Buttons
        elements.put("Add_Task_Button", this::getAddNewTaskButton);
        elements.put("View_Task_List_Button", this::getViewTaskListButton);
        elements.put("Close_Task_Button", this::getCloseTaskButton);
        elements.put("Yes_Modal_Button", this::getYesModalButton);
        elements.put("Add_Comment_Button", this::getAddCommentButton);
        elements.put("Close_Project_Button", this::getCloseThisProjectButton);
        elements.put("Configure_Project_Button", this::getConfigureThisProjectButton);
        elements.put("Add_SubTask_Button", this::getAddSubTaskButton);
        elements.put("Duplicate_To_Project_Button", this::getDuplicateToProjectButton);
        elements.put("Save_Modal_Button", this::getSaveModalButton);
        // Dropdowns
        elements.put("Project_Configurations_Dropdown", this::getProjectConfigDropdown);
        elements.put("Select_Project_To_CopyTo_Dropdown", this::getSelectProjectToCopyToDropdown);
        // TextFields & TextAreas
        elements.put("Project_Name_Modal_TextField", this::getProjectNameModalTextField);
        elements.put("Form_Title_TextField", this::getFormTitleTextField);
        elements.put("Comment_Modal_TextArea", this::getCommentModalTextArea);
        // Other
        elements.put("Project_Title", this::getProjectTitle);
        elements.put("Existing_Task_Title", this::getExistingTaskTitle);
        elements.put("Existing_SubTask_Title", this::getExistingSubTaskTitle);
        elements.put("Added_Comment", this::getAddedComment);
        elements.put("Task_State", this::getTaskState);
        elements.put("Project_State", this::getProjectState);
        elements.put("Link_To_Duplicated_Task", this::getLinkToDuplicatedTask);
        return elements;
    }
}
