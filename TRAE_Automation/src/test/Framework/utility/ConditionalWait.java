package utility;

import core.DriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static dataread.DataRead.configUiDTO;

public class ConditionalWait {
    public void waitForDisplayed(WebElement element) {
        DriverUtility.getExplicitWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForNotVisible(WebElement element) {
        DriverUtility.getExplicitWait().until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForToBeClickable(By locator) {
        DriverUtility.getExplicitWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForToBeClickable(WebElement element) {
        DriverUtility.getExplicitWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForAlert(){
        DriverUtility.getExplicitWait().until(ExpectedConditions.alertIsPresent());
    }
}
