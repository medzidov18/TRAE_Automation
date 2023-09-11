package selenium.pageobjects;

import Framework.core.DriverUtility;

import base.BaseForm;
import elements.*;
import org.openqa.selenium.By;

public class LoginPageObject extends BaseForm {
    private final Input inputLogin = new Input(By.xpath("//div[contains(@class, 'mantine-Input-wrapper')]/input[@type='text']"), "Input Login");
    private final Input inputPassword = new Input(By.xpath("//div[contains(@class, 'mantine-Input-wrapper')]//input[@type='password']"), "Input Login");

    private final Button submitButton = new Button(By.xpath("//button[text()='Войти']"), "Login Button");

    public LoginPageObject() {
        super(By.xpath("//img[contains(@src, 'traeLogo')]"), "Login Form");
    }

    public void setLogin(String login) {
        DriverUtility.getWaits().waitForDisplayed(inputLogin.getElement());
        inputLogin.getElement().sendKeys(login);
    }

    public void setPassword(String password) {
        DriverUtility.getWaits().waitForDisplayed(inputPassword.getElement());
        inputPassword.getElement().sendKeys(password);
    }

    public void submit() {
        submitButton.getElement().click();
    }
}
