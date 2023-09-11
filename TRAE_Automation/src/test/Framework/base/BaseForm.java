package base;

import Framework.core.DriverUtility;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import core.LoggerUtility;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseForm {
    protected By uniqueFormLocator;
    @Getter
    protected String formName;

    private BaseForm() {}
    public  BaseForm(By uniqueFormLocator, String formName) {
        this.uniqueFormLocator = uniqueFormLocator;
        this.formName = formName;
    }

    public By getUniqueLocator(){
        return uniqueFormLocator;
    }

    public boolean isFormOpen(){
        boolean isOpen = false;

        DriverUtility.getWaits().waitForDisplayed(DriverUtility.getDriver().findElement(uniqueFormLocator));

        if(DriverUtility.getDriver().findElement(uniqueFormLocator).isDisplayed()) {
            LoggerUtility.info("waiting for " + formName + " is open");
            isOpen = true;
        }

        LoggerUtility.info(formName + " is isOpen is " + isOpen);
        return isOpen;

    }
}
