package ua.stupin.hw23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
1. Написать класс который создает две таблицы - Устройство, Завод
a. Таблица устройство содержит:
i. Идентификатор
ii. Тип
iii. Название модели
iv. Цену
v. Дату создания
vi. Поле описание (текст может быть большим)
vii. Флаг наличие на складе
viii. Идентификатор завода
b. Таблица завод содержит:
i.Идентификатор
ii.Название
iii.Страну
 */
public class Task1 {
    public static void main(String[] args) throws SQLException {
        String hostName = "127.0.0.1";
        String dbName = "hw23";
        String userName = "root";
        String password = "123456";
        Connection connection = null;
        Statement statement = null;
        try {
            registerSqlDriver();
            connection = getConnectionWithSqlServer(hostName, dbName, userName, password);
            connection.createStatement();
            String createTableFactory = "CREATE TABLE factory(" +
                    "id INT primary key NOT NULL," +
                    "name VARCHAR(50)," +
                    "country VARCHAR (50)" +
                    ")";
            String createTableDevice = "CREATE TABLE device(" +
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
            statement = connection.createStatement();
            statement.execute(createTableFactory);
            statement.execute(createTableDevice);
        } catch (SQLException | ClassNotFoundException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            assert connection != null;
            connection.close();
            assert statement != null;
            statement.close();
        }
    }

    private static Connection getConnectionWithSqlServer
            (String hostName, String dbName, String userName, String password) throws SQLException {
        String connectionUrl = "jdbc:mariadb://" + hostName + ":3306/" + dbName;
        return DriverManager.getConnection(connectionUrl, userName, password);
    }

    private static void registerSqlDriver() throws ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
    }
}
