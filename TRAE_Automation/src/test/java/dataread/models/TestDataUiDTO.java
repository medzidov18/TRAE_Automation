package dataread.models;

import lombok.*;
import lombok.extern.jackson.*;

import java.net.Inet4Address;

@Data
@Builder
@Jacksonized
public class TestDataUiDTO {
    private Integer minIdOfProj;
    private Integer maxIdOfProj;
    private Integer minCountOfSteps;
    private String nameOfProduct;
    private String nameOfClient;
    private String comment;
}
