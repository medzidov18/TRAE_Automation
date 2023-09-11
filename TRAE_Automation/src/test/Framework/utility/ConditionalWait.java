package utility;

import Framework.core.DriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static dataread.DataRead.configUiDTO;

public class ConditionalWait {
    private static WebDriverWait wait = new WebDriverWait(DriverUtility.getDriver(), Duration.ofSeconds(configUiDTO.getExplicitWaitDuration()));



    public void waitForDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForNotVisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
