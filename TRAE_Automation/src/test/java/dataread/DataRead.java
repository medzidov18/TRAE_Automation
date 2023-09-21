package dataread;

import dataread.models.*;
import utility.JsonReadUtility;

public class DataRead {
    private static JsonReadUtility jsonReadUtility = new JsonReadUtility();

    public static ConfigUiDTO configUiDTO = jsonReadUtility.jsonToPojo(ConfigUiDTO.class, "configUI.json");
    public static TestDataUiDTO testDataUiDTO = jsonReadUtility.jsonToPojo(TestDataUiDTO.class, "testDataUI.json");
    public static ConfigApiDTO configApiDTO = jsonReadUtility.jsonToPojo(ConfigApiDTO.class, "configAPI.json");
    public static ConfigSqlDTO configSqlDTO = jsonReadUtility.jsonToPojo(ConfigSqlDTO.class, "configSql.json");
    public static TestDataSqlDTO testDataSqlDTO = jsonReadUtility.jsonToPojo(TestDataSqlDTO.class, "testDataSql.json");
}
