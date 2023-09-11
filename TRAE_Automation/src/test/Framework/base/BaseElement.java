package base;

import Framework.core.DriverUtility;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import core.LoggerUtility;

public abstract class BaseElement {
    protected By uniqueLocator;
    @Getter
    protected String elementName;

    private BaseElement(){}
    public BaseElement(By uniqueLocator, String elementName) {
        this.uniqueLocator = uniqueLocator;
        this.elementName = elementName;
    }

    public WebElement getElement(){
        return DriverUtility.getDriver().findElement(uniqueLocator);
    }

    @SneakyThrows
    public void clickElement() {
        scrollToElement();
        LoggerUtility.info("Clicking to: " + elementName);
        Thread.sleep(100);
        DriverUtility.getWaits().waitForToBeClickable(uniqueLocator);
        getElement().click();
    }

    public void scrollToElement() {
        LoggerUtility.info("Scrolling to: " + elementName);
        DriverUtility.getActions().scrollToElement(getElement());
    }

    public boolean checkIsDisplayed(){
        boolean isDisplayed = false;

        if(DriverUtility.getDriver().findElement(uniqueLocator).isDisplayed()) {
            LoggerUtility.info("waiting for " + elementName + " is open");
            isDisplayed = true;
        }

        LoggerUtility.info(elementName + " is isOpen is " + isDisplayed);
        return isDisplayed;

    }
    public boolean checkIsNotDisplayed(){
        boolean isNotDisplayed = false;

        if(DriverUtility.getDriver().findElement(uniqueLocator).isDisplayed()) {
            LoggerUtility.info("waiting for " + elementName + " is not open");
            isNotDisplayed = true;
        }

        LoggerUtility.info(elementName + " is isNotOpen is " + isNotDisplayed);
        return isNotDisplayed;
    }
}
