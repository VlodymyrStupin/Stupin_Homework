package ua.stupin.hw23;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
Написать класс который:
● Генерирует 10 устройств и 4 завода, связывает устройства с заводами и сохраняет в базу данных,
● Достает информацию по конкретному устройству и заводу изготовителю - отображает пользователю
(необходимо преобразование из ResultSet в POJO)
● Изменяет данные этого устройства и сохраняет в базу
● Удаляет конкретное устройство
● Достает список всех устройств изготовленных на конкретном заводе (join)
● Достает количество устройств, сумму цен этих устройств для каждого завода (group by)
 */
public class Task2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String hostName = "127.0.0.1";
        String dbName = "hw23";
        String userName = "root";
        String password = "123456";
        Connection connection;
        Statement statement = null;
        String connectionUrl = "jdbc:mariadb://" + hostName + ":3306/" + dbName;
        System.out.println("Registering JDBC driver:");
        Class.forName("org.mariadb.jdbc.Driver");
        System.out.println("Creating connection:");
        connection = DriverManager.getConnection(connectionUrl, userName, password);
        connection.setAutoCommit(false);
        int absoluteAddressForNavigationResultSet = 6;
        int idForDeletingFromDeviceTable = 3;
        int idForGetListAllDeviceInFactoryTable = 3;
        try {
            statement = connection.createStatement();
            insertValuesIntoFactoryTable(statement);
            insertValuesIntoDeviceTable(statement);
            statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_UPDATABLE);
            System.out.println(readFromTableAndCreateNewDevice(statement, absoluteAddressForNavigationResultSet));
            System.out.println(readFromTableAndCreateNewFactory(statement, readFromTableAndCreateNewDevice(statement,
                    absoluteAddressForNavigationResultSet).factoryID));
            changePriceInDeviceTableByID(statement, absoluteAddressForNavigationResultSet);
            deleteDeviceFromDeviceTable(statement, idForDeletingFromDeviceTable);
            System.out.println(getListAllDevicesInFactory(statement, idForGetListAllDeviceInFactoryTable));
            for (String element : getQuantityOfTypeAndSumOfDevicesPriceFromEachFactory(statement)) {
                getQuantityOfTypeAndSumOfDevicesPriceFromEachFactory(statement);
                System.out.println(element);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            connection.close();
        }
    }

    private static List<String> getQuantityOfTypeAndSumOfDevicesPriceFromEachFactory(Statement statement) throws SQLException {
        String sql = "SELECT device.factoryID, COUNT(TYPE), SUM(price) AS sumPrice FROM device GROUP BY device.factoryID   ";
        ResultSet resultSet = statement.executeQuery(sql);
        List<String> listOfInformationAboutDevicesByFactory = new ArrayList<>();
        while (resultSet.next()) {
            listOfInformationAboutDevicesByFactory.add("factoryID: " + resultSet.getString("device.factoryID") + " " +
                    "quantity of type: " + resultSet.getString("COUNT(TYPE)") + " " +
                    "sum of price: " + resultSet.getString("sumPrice"));
        }
        return listOfInformationAboutDevicesByFactory;
    }

    private static List<Device> getListAllDevicesInFactory(
            Statement statement, int idForGetListAllDeviceInFactory) throws SQLException {
        String sql = "SELECT * FROM device INNER JOIN factory " +
                "ON device.factoryID = factory.id WHERE factory.id =" + idForGetListAllDeviceInFactory;
        ResultSet resultSet = statement.executeQuery(sql);
        List<Device> deviceList = new ArrayList<>();
        while (resultSet.next()) {
            Device device1 = new Device(
                    resultSet.getInt("iD"),
                    resultSet.getString("type"),
                    resultSet.getString("modelName"),
                    resultSet.getInt("price"),
                    resultSet.getDate("creationDate"),
                    resultSet.getString("description"),
                    resultSet.getBoolean("availabilityInWarehouse"),
                    resultSet.getInt("factoryID"));
            deviceList.add(device1);
        }
        return deviceList;
    }

    private static void deleteDeviceFromDeviceTable(
            Statement statement, int idForDeletingFromDeviceTable) throws SQLException {
        String sql = "DELETE FROM device WHERE id =" + idForDeletingFromDeviceTable;
        statement.execute(sql);
    }

    private static void insertValuesIntoDeviceTable(Statement statement) throws SQLException {
        String sql = "INSERT INTO device VALUES (1, 'phone', 'S1', 200, '2022-07-01', 'no text', 'available', 1)";
        statement.addBatch(sql);
        sql = "INSERT INTO device VALUES (2, 'phone', 'S2', 400, '2022-07-02', 'no text', 'available', 1)";
        statement.addBatch(sql);
        sql = "INSERT INTO device VALUES (3, 'notebook', 'a550', 1200, '2022-07-02', 'no text', 'available', 1)";
        statement.addBatch(sql);
        sql = "INSERT INTO device VALUES (4, 'chair', 'red wood', 75, '2021-04-19', 'no text', 'available', 2)";
        statement.addBatch(sql);
        sql = "INSERT INTO device VALUES (5, 'bookcase', 'white wood', 90, '2000-01-02', 'no text', 'unavailable', 2)";
        statement.addBatch(sql);
        sql = "INSERT INTO device VALUES (6, 'engine', 'XV-40', 15000, '2022-11-24', 'no text', 'available', 3)";
        statement.addBatch(sql);
        sql = "INSERT INTO device VALUES (7, 'shirt', 'cotton', 10, '2022-09-11', 'no text', 'available', 4)";
        statement.addBatch(sql);
        sql = "INSERT INTO device VALUES (8, 'pants', 'jeans', 50, '2022-09-11', 'no text', 'available', 4)";
        statement.addBatch(sql);
        sql = "INSERT INTO device VALUES (9, 'dress', 'georgette', 100, '2022-09-11', 'no text', 'available', 4)";
        statement.addBatch(sql);
        sql = "INSERT INTO device VALUES (10, 'sweater', 'polyester', 20, '2022-01-12', 'no text', 'unavailable', 4)";
        statement.addBatch(sql);
        statement.executeBatch();
    }

    private static void insertValuesIntoFactoryTable(Statement statement) throws SQLException {
        String sql = "INSERT INTO factory VALUES (1, 'electronic production', 'Japan')";
        statement.addBatch(sql);
        sql = "INSERT INTO factory VALUES (2, 'furniture  production', 'Ukraine')";
        statement.addBatch(sql);
        sql = "INSERT INTO factory VALUES (3, 'engine production', 'Germany')";
        statement.addBatch(sql);
        sql = "INSERT INTO factory VALUES (4, 'clothes production', 'Poland')";
        statement.addBatch(sql);
        statement.executeBatch();
    }

    private static Device readFromTableAndCreateNewDevice(
            Statement statement, int absoluteAddressForNavigationResultSet) throws SQLException {
        String sql = "SELECT * FROM device WHERE id =" + absoluteAddressForNavigationResultSet;
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.first();
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

    private static Factory readFromTableAndCreateNewFactory(Statement statement, int factoryID) throws SQLException {
        String sql = "SELECT * FROM factory WHERE id = " + factoryID;
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.first();
        return new Factory(
                resultSet.getInt("iD"),
                resultSet.getString("name"),
                resultSet.getString("country"));
    }

    private static void changePriceInDeviceTableByID(
            Statement statement, int absoluteAddressForNavigationResultSet) throws SQLException {
        String sql = "UPDATE device SET price = 100000 WHERE id =  " + absoluteAddressForNavigationResultSet;
        statement.addBatch(sql);
        statement.executeBatch();
    }
}

