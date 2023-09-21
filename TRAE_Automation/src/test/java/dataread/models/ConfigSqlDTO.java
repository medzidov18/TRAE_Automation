package dataread.models;

import lombok.*;
import lombok.extern.jackson.*;

@Data
@Builder
@Jacksonized
public class ConfigSqlDTO {
    private String connectionString;
    private String userName;
    private String userPassword;
}
