package ua.stupin.hw23;

import ua.stupin.hw23.config.ConnectionConfig;
import ua.stupin.hw23.entity.Device;
import ua.stupin.hw23.repository.DeviceRepositoryImpl;
import ua.stupin.hw23.repository.FactoryRepositoryImpl;

import java.sql.SQLException;

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
        FactoryRepositoryImpl factoryRepositoryImpl = new FactoryRepositoryImpl(hostName, dbName, userName, password);
        DeviceRepositoryImpl deviceRepositoryImpl = new DeviceRepositoryImpl(hostName, dbName, userName, password);
        ConnectionConfig connectionConfig = new ConnectionConfig();
        connectionConfig.registerSqlDriver();
        int id = 2;
        int idForUpdatingDevice = 1;
        //methods
        factoryRepositoryImpl.insertValuesIntoFactoryTable();
        deviceRepositoryImpl.insertValuesIntoDeviceTable();
        System.out.println(deviceRepositoryImpl.selectByID(id));
        System.out.println(factoryRepositoryImpl.selectByID(id));
        Device device = deviceRepositoryImpl.selectByID(id);
        deviceRepositoryImpl.updateDeviceByID(device, idForUpdatingDevice);
        deviceRepositoryImpl.deleteDeviceById(id);
        deviceRepositoryImpl.selectAllDevicesMadeByFactory(id).forEach(System.out::println);
        deviceRepositoryImpl.getQuantityOfTypeAndSumOfDevicesPriceFromEachFactory().forEach(System.out::println);
    }
}

