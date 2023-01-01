package ua.stupin.hw23.config;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfig {
    public void registerSqlDriver() throws ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
    }

    @SneakyThrows
    public Connection createConnectionWithSqlServer
            (String hostName, String dbName, String userName, String password) {
        String connectionUrl = "jdbc:mariadb://" + hostName + ":3306/" + dbName;
        return DriverManager.getConnection(connectionUrl, userName, password);
    }
}
