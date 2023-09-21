package api.requests;

import api.models.LoginModel;
import dataread.StatusCodes;
import io.restassured.response.Response;

import static api.specifications.Specifications.*;
import static dataread.DataRead.configApiDTO;
import static io.restassured.RestAssured.given;

public class ProjectsRequests {
    public static Response deleteProject(Integer projectId) {
        return given().
                spec(requestSpecProjects).
                delete(configApiDTO.getDeleteProjectRequest() + String.format("/%s", projectId));
    }
}
