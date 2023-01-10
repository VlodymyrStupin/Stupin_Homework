package ua.stupin.hw23;

import ua.stupin.hw23.config.ConnectionConfig;
import ua.stupin.hw23.repository.DeviceRepositoryImpl;
import ua.stupin.hw23.repository.FactoryRepositoryImpl;

import java.sql.SQLException;

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
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String hostName = "127.0.0.1";
        String dbName = "hw23";
        String userName = "root";
        String password = "123456";
        FactoryRepositoryImpl factoryRepositoryImpl = new FactoryRepositoryImpl(hostName, dbName, userName, password);
        DeviceRepositoryImpl deviceRepositoryImpl = new DeviceRepositoryImpl(hostName, dbName, userName, password);
        ConnectionConfig connectionConfig = new ConnectionConfig();
        connectionConfig.registerSqlDriver();
        factoryRepositoryImpl.createTable();
        deviceRepositoryImpl.createTable();
    }
}
