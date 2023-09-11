package elements;

import base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import core.LoggerUtility;

public class TextBox extends BaseElement {
    public TextBox(By uniqueLocator, String elementName) {
        super(uniqueLocator, elementName);
    }

    public void clear(){
        LoggerUtility.info("Clearing label...");
        getElement().sendKeys(Keys.BACK_SPACE);
    }

}
