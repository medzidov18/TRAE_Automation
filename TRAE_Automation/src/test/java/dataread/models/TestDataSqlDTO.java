package dataread.models;

import lombok.*;
import lombok.extern.jackson.*;

@Data
@Builder
@Jacksonized
public class TestDataSqlDTO {
    private String getIdOfProjectByNumber;
}
