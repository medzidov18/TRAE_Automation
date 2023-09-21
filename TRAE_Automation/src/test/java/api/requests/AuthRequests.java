package api.requests;

import api.models.LoginModel;
import dataread.StatusCodes;
import io.opentelemetry.api.trace.StatusCode;

import static api.specifications.Specifications.*;
import static dataread.DataRead.*;
import static io.restassured.RestAssured.*;

public class AuthRequests {
    public static String loginAndGetAccessToken(LoginModel loginModel) {
        return given().
                spec(requestSpecAuth).
                body(loginModel).
                post(configApiDTO.getLoginRequest()).
                then().
                statusCode(StatusCodes.OK_200.getValue()).
                extract().path("accessToken");
    }
}
