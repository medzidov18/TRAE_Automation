package tests.steps;

import api.models.LoginModel;
import api.requests.AuthRequests;
import lombok.SneakyThrows;
import selenium.pageobjects.LoginPageObject;

import static dataread.DataRead.configUiDTO;

public class AuthSteps {
    private final LoginPageObject loginPageObject = new LoginPageObject();

    @SneakyThrows
    public void loginAsAdmin() {
        loginPageObject.setLogin(configUiDTO.getLoginAdmin());
        loginPageObject.setPassword(configUiDTO.getPasswordAdmin());
        loginPageObject.submit();
    }
}
