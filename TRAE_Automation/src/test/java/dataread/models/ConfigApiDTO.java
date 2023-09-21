package dataread.models;

import lombok.*;
import lombok.extern.jackson.*;

@Data
@Builder
@Jacksonized
public class ConfigApiDTO {
    private String baseURI;
    private String authUrl;
    private String projectsUrl;
    private String loginRequest;
    private String deleteProjectRequest;
    private String authHeader;
}
