package course_project.ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPageElements {


    // <-------------- Buttons -------------->
    public SelenideElement newProjectButton() {
        return $(".page-header ul li:first-of-type");
    }

    public SelenideElement modalSaveButton() {
        return $("[class='btn btn-blue']");
    }

    public SelenideElement addNewTaskButton() {
        return $(".dropdown-submenu-open li:nth-child(4)");
    }

    public SelenideElement viewListingButton() {
        return $("[class='view-listing']");
    }

    public SelenideElement closeTaskButton() {
        return $("[class='fa fa-times fa-fw js-modal-confirm']");
    }

    public SelenideElement yesModalButton() {
        return $("[id='modal-confirm-button']");
    }

    public SelenideElement addCommentButton() {
        return $("li:nth-child(6) > a.js-modal-small");
    }

    public SelenideElement closeThisProjectButton() {
        return $(".sidebar ul:nth-child(1) > li:nth-child(17)");
    }

    public SelenideElement configureThisProjectButton() {
        return $(".dropdown-submenu-open li:nth-child(10)");
    }

    public SelenideElement addSubTaskButton() {
        return $(".sidebar-icons ul:nth-child(4) > li:nth-child(3)");
    }

    public SelenideElement saveSubTaskButton() {
        return $(".js-submit-buttons-rendered:nth-child(11) div.form-actions > button.btn.btn-blue:nth-child(1)");
    }

    public SelenideElement saveCommentButton() {
        return $("div.js-submit-buttons-rendered:nth-child(3) div.form-actions > button.btn.btn-blue:nth-child(1)");
    }

    public SelenideElement duplicateToProjectButton() {
        return $(".sidebar-icons ul:nth-child(4) > li:nth-child(10)");
    }

    // <-------------- Icons ---------------->

    public SelenideElement projectGearIcon() {
        return $("[class='fa fa-cog']");
    }

    // <------ TextFields & TextAreas ------->

    public SelenideElement projectNameModalTextField() {
        return $("[id='form-name']");
    }


    public SelenideElement commentModalTextArea() {
        return $("div.js-text-editor-rendered:nth-child(2) div.text-editor:nth-child(2) div.text-editor-write-mode > textarea:nth-child(2)");
    }

    public SelenideElement formTitleTextField() {
        return $("[id=form-title]");
    }


    // <-------------- Other ---------------->
    public SelenideElement mainPageBody() {
        return $("[id='main']");
    }

    public SelenideElement projectTitle() {return $(".title-container h1:nth-child(1) > span.title");}

    public SelenideElement existingTaskTitle() {
        return $("[class='table-list-title ']");
    }

    public SelenideElement existingSubTaskTitle() {
        return $(".subtask-title > a.js-subtask-toggle-status");
    }

    public SelenideElement addedComment() {
        return $("div.markdown > p:nth-child(1)");
    }

    public SelenideElement taskStatus() {
        return $(".task-summary-column:nth-child(1) ul.no-bullet li:nth-child(1) > span:nth-child(2)");
    }

    public SelenideElement summaryProjectState() {
        return $(".panel:nth-child(2) li:nth-child(1) > strong:nth-child(1)");
    }

    public SelenideElement linkToDuplicatedTask() {
        return $(".table-scrolling tbody:nth-child(1) tr:nth-child(2) td:nth-child(1) > a:nth-child(2)");
    }
}
