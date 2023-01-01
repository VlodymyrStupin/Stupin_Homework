package ua.stupin.hw23.repository;

import lombok.SneakyThrows;
import ua.stupin.hw23.config.ConnectionConfig;
import ua.stupin.hw23.entity.Factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FactoryRepositoryImpl implements FactoryRepository, GenericRepository<Factory> {
    private final ConnectionConfig connectionConfig = new ConnectionConfig();
    private final String selectFactoryByID = "SELECT * FROM factory WHERE id = ?;";
    private final String insertValuesIntoFactoryTable = "INSERT INTO factory VALUES " +
            "(1, 'electronic production', 'Japan')," +
            "(2, 'furniture  production', 'Ukraine')," +
            "(3, 'engine production', 'Germany')," +
            "(4, 'clothes production', 'Poland');";
    private final String createTableFactory = "CREATE TABLE factory(" +
            "id INT primary key NOT NULL," +
            "name VARCHAR(50)," +
            "country VARCHAR (50)" +
            ")";

    @Override
    @SneakyThrows
    public void createTable(String hostName, String dbName, String userName, String password) {
        connectionConfig.registerSqlDriver();
        try (Connection connection = connectionConfig.createConnectionWithSqlServer(hostName, dbName, userName, password);
             PreparedStatement statement = connection.prepareStatement(createTableFactory)) {
            statement.execute();
        }
    }

    @Override
    @SneakyThrows
    public void insertValuesIntoFactoryTable(String hostName, String dbName, String userName, String password) {
        connectionConfig.registerSqlDriver();
        try (Connection connection = connectionConfig.createConnectionWithSqlServer(hostName, dbName, userName, password);
             PreparedStatement statement = connection.prepareStatement(insertValuesIntoFactoryTable)) {
            statement.execute();
        }
    }

    @Override
    @SneakyThrows
    public Factory selectByID(String hostName, String dbName, String userName, String password, int id) {
        connectionConfig.registerSqlDriver();
        ResultSet resultSet = null;
        try (Connection connection = connectionConfig.createConnectionWithSqlServer(hostName, dbName, userName, password);
             PreparedStatement statement = connection.prepareStatement(selectFactoryByID)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            resultSet.first();
        }
        return new Factory(resultSet.getInt("iD"),
                resultSet.getString("name"),
                resultSet.getString("country"));
    }
}
