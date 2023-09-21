package api.specifications;

import api.models.LoginModel;
import api.requests.AuthRequests;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import tests.steps.AuthSteps;

import static dataread.DataRead.configApiDTO;
import static dataread.DataRead.configUiDTO;

public class Specifications {
    private final static LoginModel loginModel = new LoginModel(configUiDTO.getPasswordAdmin(), configUiDTO.getLoginAdmin());
    protected final static String accessToken = AuthRequests.loginAndGetAccessToken(loginModel);

    public static RequestSpecification requestSpecAuth = new RequestSpecBuilder()
            .setBaseUri(configApiDTO.getBaseURI() + configApiDTO.getAuthUrl())
            .setContentType("application/json")
            .build();

    public static RequestSpecification requestSpecProjects = new RequestSpecBuilder()
            .setBaseUri(configApiDTO.getBaseURI() + configApiDTO.getProjectsUrl())
            .addHeader(configApiDTO.getAuthHeader(), String.format("Bearer %s", accessToken))
            .setContentType("application/json")
            .build();

}
