package ua.stupin.hw23.repository;

import lombok.SneakyThrows;
import ua.stupin.hw23.config.ConnectionConfig;
import ua.stupin.hw23.entity.Factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FactoryRepositoryImpl implements FactoryRepository, GenericRepository<Factory> {
    private String hostName;
    private String dbName;
    private String userName;
    private String password;

    public FactoryRepositoryImpl(String hostName, String dbName, String userName, String password) {
        this.hostName = hostName;
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
    }

    private final ConnectionConfig connectionConfig = new ConnectionConfig();
    private final String SELECT_FACTORY_BY_ID = "SELECT * FROM factory WHERE id = ?;";
    private final String INSERT_VALUES_INTO_FACTORY_TABLE = "INSERT INTO factory VALUES " +
            "(1, 'electronic production', 'Japan')," +
            "(2, 'furniture  production', 'Ukraine')," +
            "(3, 'engine production', 'Germany')," +
            "(4, 'clothes production', 'Poland');";
    private final String CREATE_TABLE_FACTORY = "CREATE TABLE factory(" +
            "id INT primary key NOT NULL," +
            "name VARCHAR(50)," +
            "country VARCHAR (50)" +
            ")";

    @Override
    @SneakyThrows
    public void createTable() {
        try (Connection connection = connectionConfig.createConnection(hostName, dbName, userName, password);
             PreparedStatement statement = connection.prepareStatement(CREATE_TABLE_FACTORY)) {
            statement.execute();
        }
    }

    @Override
    @SneakyThrows
    public void insertValuesIntoFactoryTable() {
        try (Connection connection = connectionConfig.createConnection(hostName, dbName, userName, password);
             PreparedStatement statement = connection.prepareStatement(INSERT_VALUES_INTO_FACTORY_TABLE)) {
            statement.execute();
        }
    }

    @Override
    @SneakyThrows
    public Factory selectByID(int id) {
        ResultSet resultSet = null;
        try (Connection connection = connectionConfig.createConnection(hostName, dbName, userName, password);
             PreparedStatement statement = connection.prepareStatement(SELECT_FACTORY_BY_ID)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            resultSet.first();
        }
        return new Factory(resultSet.getInt("iD"),
                resultSet.getString("name"),
                resultSet.getString("country"));
    }
}
