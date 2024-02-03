package elements;


import com.codeborne.selenide.SelenideElement;

public abstract class BasePage {
    public abstract SelenideElement getWebElementByName(String elementName);
}
