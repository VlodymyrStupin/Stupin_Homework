package ua.stupin.hw23.repository;

public interface FactoryRepository {
    void insertValuesIntoFactoryTable(String hostName, String dbName, String userName, String password);
}
