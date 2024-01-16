package course_project.ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPageElements {


    // <-------------- Buttons -------------->
    public SelenideElement newProjectButton() {
        return $(".page-header ul li:first-of-type");
    }

    public SelenideElement saveProjectButton() {
        return $("[class='btn btn-blue']");
    }

    public SelenideElement addNewTaskButton() {
        return $(".dropdown-submenu-open li:nth-child(4)");
    }

    public SelenideElement saveTaskButton() {

        return $("[class='btn btn-blue']");
    }

    public SelenideElement viewListingButton() {
        return $("[class='view-listing']");
    }

    public SelenideElement closeTaskButton() {
        return $("[class='fa fa-times fa-fw js-modal-confirm']");
    }

    public SelenideElement confirmTaskClosingButton() {
        return $("[id='modal-confirm-button']");
    }

    public SelenideElement addCommentButton() {
        return $("li:nth-child(6) > a.js-modal-small");
    }

    public SelenideElement saveCommentButton() {
        return $("div.js-submit-buttons-rendered:nth-child(3) div.form-actions > button.btn.btn-blue:nth-child(1)");
    }

    // <-------------- Icons ---------------->

    public SelenideElement projectGearIcon() {
        return $("[class='fa fa-cog']");
    }

    // <------ TextFields & TextAreas ------->

    public SelenideElement projectNameTextField() {
        return $("[id='form-name']");
    }

    public SelenideElement projectIdentifierTextField() {
        return $("[id='form-identifier']");
    }

    public SelenideElement newTaskDescriptionTextField() {
        return $("[name='description']");
    }

    public SelenideElement commentTextArea() {
        return $("div.js-text-editor-rendered:nth-child(2) div.text-editor:nth-child(2) div.text-editor-write-mode > textarea:nth-child(2)");
    }


    // <-------------- Other ---------------->
    public SelenideElement mainPageBody() {
        return $("[id='main']");
    }

    public SelenideElement taskTitleInList() {
        return $("[class='table-list-title ']");
    }

    public SelenideElement newTaskTitle() {
        return $("[id=form-title]");
    }

    public SelenideElement taskStatus() {
        return $(".task-summary-column:nth-child(1) ul.no-bullet li:nth-child(1) > span:nth-child(2)");
    }

    public SelenideElement addedComment() {
        return $("div.markdown > p:nth-child(1)");
    }
}
