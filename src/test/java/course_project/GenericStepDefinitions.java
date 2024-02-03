package course_project;

import com.codeborne.selenide.SelenideElement;
import ui.pages.BasePage;
import ui.pages.LoginPageElements;
import ui.pages.MainPageElements;
import ui.pages.ProjectPageElements;
import customexceptions.PageNotFoundException;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class GenericStepDefinitions {

    LoginPageElements loginPage = new LoginPageElements();
    MainPageElements mainPage = new MainPageElements();
    ProjectPageElements projectPage = new ProjectPageElements();

    // Clicks
    @When("{element} has been clicked")
    public void clickElement(SelenideElement webElementFacade) {
        clickOnElement(webElementFacade);
    }

    // Fills
    @When("Text {string} was entered into {element}")
    public void inputTextInField(String text, SelenideElement element) {
        element.clear();
        element.sendKeys(text);
    }

    // Asserts
    @Then("The {element} should be displayed")
    public void elementIsDisplayed(SelenideElement element) {
        Assert.assertTrue(element.isDisplayed());
    }

    @Then("Text {string} should be displayed in {element}")
    public void doesElementContainsText(String text, SelenideElement element) {
        Assert.assertEquals(element.getText(), text);
    }

    @Then("Trimmed text of the {element} should be {string}")
    public void checkElementText(SelenideElement element, String expectedState) {
        String rawState = element.getText();

        String[] words = rawState.split("\\s+");
        String actualState = words[words.length -1];

        sleep(500);
        Assert.assertEquals(actualState, expectedState);
    }

    // Elements Definer
    @ParameterType("(\\w+) on (\\w+)")
    public SelenideElement element(String element, String page) {
        return getElementByNameOnPage(element, page);
    }

    private void clickOnElement(SelenideElement element) {
        element.shouldBe(visible);
        element.click();
    }

    // Elements Page & Map Assembling
    public SelenideElement getElementByNameOnPage(String elementName, String pageTypeName) {
        Map<String, BasePage> pages = getPagesNamesAndPageObjectsMap();
        if (pages.get(pageTypeName) == null) {
            throw new PageNotFoundException(pageTypeName, pages.keySet().toString());
        }
        return pages.get(pageTypeName).getWebElementByName(elementName);
    }

    private Map<String, BasePage> getPagesNamesAndPageObjectsMap() {
        Map<String, BasePage> pages = new HashMap<>();
        pages.put("Login_Page", loginPage);
        pages.put("Main_Page", mainPage);
        pages.put("Project_Page", projectPage);
        return pages;
    }

}