package ua.stupin.hw23.repository;

import ua.stupin.hw23.entity.Device;

import java.util.List;

public interface DeviceRepository {
    void insertValuesIntoDeviceTable();

    void updateDeviceByID(Device device, int id);

    void deleteDeviceById(int id);

    List<Device> selectAllDevicesMadeByFactory(int id);

    List<String> getQuantityOfTypeAndSumOfDevicesPriceFromEachFactory();
}
