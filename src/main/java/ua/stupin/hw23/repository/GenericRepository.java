package ua.stupin.hw23.repository;

public interface GenericRepository<T> {
    T selectByID(String hostName, String dbName, String userName, String password, int id);

    public void createTable(String hostName, String dbName, String userName, String password);
}
