package elements;

import base.BaseElement;
import core.LoggerUtility;
import org.openqa.selenium.By;

public class Input extends BaseElement {
    public Input(By uniqueLocator, String elementName) {
        super(uniqueLocator, elementName);
    }

    public void InputData(String data){
        LoggerUtility.info("Sending data: " + data + " to the " + super.getElementName());
        getElement().sendKeys(data);
    }
}
