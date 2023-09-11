package dataread.models;

import lombok.*;
import lombok.extern.jackson.*;

@Data
@Builder
@Jacksonized
public class ConfigUiDTO {
    private String remoteAllowGC;
    private String useIncognitoGC;
    private String removeImagesGC;
    private Integer implicitWaitDuration;
    private Integer explicitWaitDuration;
    private String baseUri;
    private String loginAdmin;
    private String passwordAdmin;
    private String valueAttribute;
}