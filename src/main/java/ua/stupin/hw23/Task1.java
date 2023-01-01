package ua.stupin.hw23;

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
    public static void main(String[] args) throws SQLException {
        String hostName = "127.0.0.1";
        String dbName = "hw23";
        String userName = "root";
        String password = "123456";
        FactoryRepositoryImpl factoryRepositoryImpl = new FactoryRepositoryImpl();
        DeviceRepositoryImpl deviceRepositoryImpl = new DeviceRepositoryImpl();
        factoryRepositoryImpl.createTable(hostName, dbName, userName, password);
        deviceRepositoryImpl.createTable(hostName, dbName, userName, password);
    }
}
