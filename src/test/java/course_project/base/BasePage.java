package course_project.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickOnElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }
    protected void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    protected String getElementText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    protected WebElement waitForElement(By by, int time){
        return new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.presenceOfElementLocated(by));
    }


    protected List<WebElement> waitForElements(By by, int time){
        return new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    protected boolean waitTillDisappear(By by, int time){
        return new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}
