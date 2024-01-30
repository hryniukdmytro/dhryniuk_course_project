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

    public final SelenideElement modalSaveButton = $("[class='btn btn-blue']");
    public final SelenideElement addNewTaskButton = $(".dropdown-submenu-open li:nth-child(4)");
    public final SelenideElement viewListingButton = $("[class='view-listing']");
    public final SelenideElement closeTaskButton = $("[class='fa fa-times fa-fw js-modal-confirm']");
    public final SelenideElement yesModalButton = $("[id='modal-confirm-button']");
    public final SelenideElement addCommentButton = $("li:nth-child(6) > a.js-modal-small");
    public final SelenideElement closeThisProjectButton = $(".sidebar ul:nth-child(1) > li:nth-child(17)");
    public final SelenideElement configureThisProjectButton = $(".dropdown-submenu-open li:nth-child(10)");
    public final SelenideElement addSubTaskButton = $(".sidebar-icons ul:nth-child(4) > li:nth-child(3)");
    public final SelenideElement duplicateToProjectButton = $(".sidebar-icons ul:nth-child(4) > li:nth-child(10)");
    public final SelenideElement saveSubTaskButton = $(".js-submit-buttons-rendered:nth-child(11) div.form-actions > button.btn.btn-blue:nth-child(1)");
    public final SelenideElement saveCommentButton = $("div.js-submit-buttons-rendered:nth-child(3) div.form-actions > button.btn.btn-blue:nth-child(1)");
    public final SelenideElement duplicateTaskSaveButton = $(".js-submit-buttons-rendered:nth-child(17) div.form-actions > button.btn.btn-blue:nth-child(1)");

    // <-------------- Dropdowns ------------>

    public final SelenideElement projectConfigDropdown = $("[class='fa fa-cog']");
    public final SelenideElement selectProjectToCopyToDropdown = $(".js-select-dropdown-autocomplete-rendered:nth-child(4) > div.select-dropdown-input-container");

    // <------ TextFields & TextAreas ------->

    public final SelenideElement projectNameModalTextField = $("[id='form-name']");
    public final SelenideElement formTitleTextField = $("[id=form-title]");
    public final SelenideElement commentModalTextArea = $("div.js-text-editor-rendered:nth-child(2) div.text-editor:nth-child(2) div.text-editor-write-mode > textarea:nth-child(2)");

    // <-------------- Other ---------------->

    public final SelenideElement projectTitle = $(".title-container h1:nth-child(1) > span.title");
    public final SelenideElement existingTaskTitle = $("[class='table-list-title ']");
    public final SelenideElement existingSubTaskTitle = $(".subtask-title > a.js-subtask-toggle-status");
    public final SelenideElement addedComment = $("div.markdown > p:nth-child(1)");
    public final SelenideElement taskState = $("div.task-summary-column:nth-child(1) ul.no-bullet li:nth-child(1) > span:nth-child(2)");
    public final SelenideElement projectState = $(".panel:nth-child(2) li:nth-child(1) > strong:nth-child(1)");
    public final SelenideElement linkToDuplicatedTask = $(".table-scrolling tbody:nth-child(1) tr:nth-child(2) td:nth-child(1) > a:nth-child(2)");


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
        elements.put("Modal_Save_Button", this::getModalSaveButton);
        elements.put("Add_Task_Button", this::getAddNewTaskButton);
        elements.put("View_Task_List_Button", this::getViewListingButton);
        elements.put("Close_Task_Button", this::getCloseTaskButton);
        elements.put("Yes_Modal_Button", this::getYesModalButton);
        elements.put("Add_Comment_Button", this::getAddCommentButton);
        elements.put("Close_Project_Button", this::getCloseThisProjectButton);
        elements.put("Configure_Project_Button", this::getConfigureThisProjectButton);
        elements.put("Add_SubTask_Button", this::getAddSubTaskButton);
        elements.put("Duplicate_To_Project_Button", this::getDuplicateToProjectButton);
        elements.put("Save_SubTask_Button", this::getSaveSubTaskButton);
        elements.put("Save_Comment_Button", this::getSaveCommentButton);
        elements.put("Duplicate_Task_Save_Button", this::getDuplicateTaskSaveButton);

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
