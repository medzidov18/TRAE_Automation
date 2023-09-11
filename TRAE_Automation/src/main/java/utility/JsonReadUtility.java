package utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import java.io.File;
import java.net.URL;

public class JsonReadUtility {
    private static ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public <T> T jsonToPojo(Class<T> myClassToDeserialize, String fileName) {
        File file = new File(String.format("src/main/resources/%s", fileName));

        return objectMapper.readValue(file, myClassToDeserialize);
    }
}
