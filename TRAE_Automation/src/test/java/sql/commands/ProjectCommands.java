package sql.commands;

import core.ConnectDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static dataread.DataRead.*;

public class ProjectCommands {
    public static Integer getProjectIdFromOperationNumber(Integer operationNumber) {
        try {
            PreparedStatement preparedStatement = ConnectDatabase.getConnection().prepareStatement(testDataSqlDTO.getGetIdOfProjectByNumber());
            preparedStatement.setInt(1, operationNumber);
            ResultSet result = preparedStatement.executeQuery();

            return result.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
