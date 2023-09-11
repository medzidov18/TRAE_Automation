package selenium.pageobjects;

import base.BaseForm;
import elements.*;
import org.openqa.selenium.By;

public class CalendarForm extends BaseForm {
    private final Button dataNextButton = new Button(By.xpath("//button[@data-next='true']"), "Next Month Button");
    private final Button dataPreviousButton = new Button(By.xpath("//button[@data-previous='true']"), "Previous Month Button");

    public CalendarForm() {
        super(By.xpath("//div[contains(@class, 'mantine-Calendar-calendar')]"), "Calendar Form");
    }

    public void clickToTHeNextMonth() {
        dataNextButton.clickElement();
    }

    public void clickToTHePreviousMonth() {
        dataPreviousButton.clickElement();
    }
}
