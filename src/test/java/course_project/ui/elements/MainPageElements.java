package course_project.ui.elements;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPageElements {


    // <-------------- Buttons -------------->
    public SelenideElement newProjectButton() {
        return $(".page-header ul li:first-of-type");
    }


    // <-------------- Other ---------------->
    public SelenideElement mainPageBody() {
        return $("[id='main']");
    }

}
