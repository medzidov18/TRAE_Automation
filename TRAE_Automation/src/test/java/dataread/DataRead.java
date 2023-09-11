package dataread;

import dataread.models.*;
import utility.JsonReadUtility;

public class DataRead {
    private static JsonReadUtility jsonReadUtility = new JsonReadUtility();

    public static ConfigUiDTO configUiDTO = jsonReadUtility.jsonToPojo(ConfigUiDTO.class, "configUI.json");
    public static TestDataUiDTO testDataUiDTO = jsonReadUtility.jsonToPojo(TestDataUiDTO.class, "testDataUI.json");
}
