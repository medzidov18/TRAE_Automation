package core;

import lombok.Getter;

import java.sql.*;

import static dataread.DataRead.*;

public class ConnectDatabase {
    @Getter
    private static Connection connection;

    private ConnectDatabase() {}

    public static void initialize() {
        try {
            connection = DriverManager.getConnection(configSqlDTO.getConnectionString(), configSqlDTO.getUserName(), configSqlDTO.getUserPassword());
        } catch (SQLException e) {
            connection = null;
            throw new RuntimeException(e);
        }
    }
}
