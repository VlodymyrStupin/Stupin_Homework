package ua.stupin.hw23.repository;

import ua.stupin.hw23.entity.Device;

import java.util.List;

public interface DeviceRepository {
    void insertValuesIntoDeviceTable(String hostName, String dbName, String userName, String password);
    void updateDeviceByID(String hostName, String dbName, String userName, String password, Device device, int id);
    void deleteDeviceById(String hostName, String dbName, String userName, String password, int id);
    List<Device> selectAllDevicesMadeByFactory(String hostName, String dbName, String userName, String password, int id);
    List<String> getQuantityOfTypeAndSumOfDevicesPriceFromEachFactory
            (String hostName, String dbName, String userName, String password);
}
