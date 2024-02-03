package course_project.ui.elements;


import com.codeborne.selenide.SelenideElement;
import course_project.ui.exceptionsHandling.ElementOnPageNotFoundException;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class MainPageElements extends BasePage {
    public final SelenideElement newProjectButton = $(".page-header ul li:first-of-type");
    public final SelenideElement mainPageBody = $("[id='main']");

    @Override
    public SelenideElement getWebElementByName(String elementName) {
        Map<String, Supplier<SelenideElement>> elements = getElementNamesAndElementGetterMap();
        if (elements.get(elementName) == null) {
            throw new ElementOnPageNotFoundException(elementName, "MainPage");
        }
        return elements.get(elementName).get();
    }

    private Map<String, Supplier<SelenideElement>> getElementNamesAndElementGetterMap() {
        Map<String, Supplier<SelenideElement>> elements = new HashMap<>();
        elements.put("New_Project_Button", this::getNewProjectButton);
        elements.put("Main_Page_Body", this::getMainPageBody);
        return elements;
    }
}
