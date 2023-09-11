package selenium.pageobjects;

import base.BaseForm;
import elements.*;
import org.openqa.selenium.By;

public class HeaderForm extends BaseForm {
    private final Button projectsButton = new Button(By.xpath("//button[text()='Проекты']"), "Project Button In Header");

    public HeaderForm() {
        super(By.xpath("//button[text()='Проекты']"), "Header Form");
    }

    public void goToProjects() {
        projectsButton.clickElement();
    }
}
