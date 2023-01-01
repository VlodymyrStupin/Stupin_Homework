package ua.stupin.hw23.repository;

import lombok.SneakyThrows;
import ua.stupin.hw23.config.ConnectionConfig;
import ua.stupin.hw23.entity.Device;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeviceRepositoryImpl implements GenericRepository<Device>, DeviceRepository {
    private final ConnectionConfig connectionConfig = new ConnectionConfig();
    private final String selectDeviceByID = "SELECT * FROM device WHERE id = ?;";
    private final String insertValuesIntoDeviceTable = "INSERT INTO device VALUES " +
            "(1, 'phone', 'S1', 200, '2022-07-01', 'no text', 'available', 1)," +
            "(2, 'phone', 'S2', 400, '2022-07-02', 'no text', 'available', 1)," +
            "(3, 'notebook', 'a550', 1200, '2022-07-02', 'no text', 'available', 1)," +
            "(4, 'chair', 'red wood', 75, '2021-04-19', 'no text', 'available', 2)," +
            "(5, 'bookcase', 'white wood', 90, '2000-01-02', 'no text', 'unavailable', 2)," +
            "(6, 'engine', 'XV-40', 15000, '2022-11-24', 'no text', 'available', 3)," +
            "(7, 'shirt', 'cotton', 10, '2022-09-11', 'no text', 'available', 4)," +
            "(8, 'pants', 'jeans', 50, '2022-09-11', 'no text', 'available', 4)," +
            "(9, 'dress', 'georgette', 100, '2022-09-11', 'no text', 'available', 4)," +
            "(10, 'sweater', 'polyester', 20, '2022-01-12', 'no text', 'unavailable', 4);";
    private final String createTableDevice = "CREATE TABLE device(" +
            "iD INT PRIMARY KEY NOT NULL," +
            "type VARCHAR(50)," +
            "modelName VARCHAR (50)," +
            "price INT," +
            "creationDate DATE," +
            "description TEXT (500)," +
            "availabilityInWarehouse Set ('available', 'unavailable')," +
            "factoryID INT NOT NULL," +
            "CONSTRAINT `fk_device_factory`" +
            "FOREIGN KEY (factoryID) REFERENCES factory (id) " +
            "ON DELETE CASCADE " +
            "ON UPDATE RESTRICT" +
            ")";
    private final String updateDeviceByID = "UPDATE device " +
            "SET " +
            "type = ?, " +
            "modelName = ?, " +
            "price = ?, " +
            "creationDate = ?, " +
            "description = ?, " +
            "availabilityInWarehouse = ?, " +
            "factoryID = ? " +
            "WHERE id = ?;";

    private final String deleteDeviceById = "DELETE FROM device WHERE id = ?";
    private final String selectAllDevicesMadeByFactory = "SELECT * FROM device INNER JOIN factory " +
            "ON device.factoryID = factory.id WHERE factory.id = ?";

    private final String getQuantityOfTypeAndSumOfDevicesPriceFromEachFactory
            = "SELECT device.factoryID, COUNT(TYPE), SUM(price) AS sumPrice FROM device GROUP BY device.factoryID";

    @Override
    @SneakyThrows
    public void createTable(String hostName, String dbName, String userName, String password) {
        connectionConfig.registerSqlDriver();
        try (Connection connection = connectionConfig.createConnectionWithSqlServer(hostName, dbName, userName, password);
             PreparedStatement statement = connection.prepareStatement(createTableDevice)) {
            statement.execute();
        }
    }

    @Override
    @SneakyThrows
    public void insertValuesIntoDeviceTable(String hostName, String dbName, String userName, String password) {
        connectionConfig.registerSqlDriver();
        try (Connection connection = connectionConfig.createConnectionWithSqlServer(hostName, dbName, userName, password);
             PreparedStatement statement = connection.prepareStatement(insertValuesIntoDeviceTable)) {
            statement.execute();
        }
    }

    @Override
    @SneakyThrows
    public Device selectByID(String hostName, String dbName, String userName, String password, int id) {
        connectionConfig.registerSqlDriver();
        ResultSet resultSet = null;
        try (Connection connection = connectionConfig.createConnectionWithSqlServer(hostName, dbName, userName, password);
             PreparedStatement statement = connection.prepareStatement(selectDeviceByID)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            resultSet.first();
        }
        return new Device(
                resultSet.getInt("iD"),
                resultSet.getString("type"),
                resultSet.getString("modelName"),
                resultSet.getInt("price"),
                resultSet.getDate("creationDate"),
                resultSet.getString("description"),
                resultSet.getBoolean("availabilityInWarehouse"),
                resultSet.getInt("factoryID"));
    }

    @Override
    @SneakyThrows
    public void updateDeviceByID(String hostName, String dbName, String userName, String password, Device device, int id) {
        connectionConfig.registerSqlDriver();
        try (Connection connection = connectionConfig.createConnectionWithSqlServer(hostName, dbName, userName, password);
             PreparedStatement statement = connection.prepareStatement(updateDeviceByID)) {
            statement.setString(1, device.getType());
            statement.setString(2, device.getModelName());
            statement.setInt(3, device.getPrice());
            statement.setDate(4, (Date) device.getCreationDate());
            statement.setString(5, device.getDescription());
            statement.setBoolean(6, device.isAvailabilityInWarehouse());
            statement.setInt(7, device.getFactoryID());
            statement.setInt(8, id);
            statement.execute();
        }
    }

    @Override
    @SneakyThrows
    public void deleteDeviceById(String hostName, String dbName, String userName, String password, int id) {
        connectionConfig.registerSqlDriver();
        try (Connection connection = connectionConfig.createConnectionWithSqlServer(hostName, dbName, userName, password);
             PreparedStatement statement = connection.prepareStatement(deleteDeviceById)) {
            statement.setInt(1, id);
            statement.execute();
        }
    }

    @Override
    @SneakyThrows
    public List<Device> selectAllDevicesMadeByFactory(String hostName, String dbName, String userName, String password, int id) {
        connectionConfig.registerSqlDriver();
        ResultSet resultSet = null;
        try (Connection connection = connectionConfig.createConnectionWithSqlServer(hostName, dbName, userName, password);
             PreparedStatement statement = connection.prepareStatement(selectAllDevicesMadeByFactory)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            List<Device> deviceList = new ArrayList<>();
            while (resultSet.next()) {
                Device device = new Device(
                        resultSet.getInt("iD"),
                        resultSet.getString("type"),
                        resultSet.getString("modelName"),
                        resultSet.getInt("price"),
                        resultSet.getDate("creationDate"),
                        resultSet.getString("description"),
                        resultSet.getBoolean("availabilityInWarehouse"),
                        resultSet.getInt("factoryID"));
                deviceList.add(device);
            }
            return deviceList;
        }
    }

    @Override
    @SneakyThrows
    public List<String> getQuantityOfTypeAndSumOfDevicesPriceFromEachFactory
            (String hostName, String dbName, String userName, String password) {
        connectionConfig.registerSqlDriver();
        ResultSet resultSet = null;
        List<String> listOfInformationAboutDevicesByFactory = new ArrayList<>();
        try (Connection connection = connectionConfig.createConnectionWithSqlServer(hostName, dbName, userName, password);
             PreparedStatement statement = connection.prepareStatement(getQuantityOfTypeAndSumOfDevicesPriceFromEachFactory)) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listOfInformationAboutDevicesByFactory.add("factoryID: " + resultSet.getString("device.factoryID") + " " +
                        "quantity of type: " + resultSet.getString("COUNT(TYPE)") + " " +
                        "sum of price: " + resultSet.getString("sumPrice"));
            }
        }
        return listOfInformationAboutDevicesByFactory;
    }
}
