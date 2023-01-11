package ua.stupin.hw23.repository;

public interface GenericRepository<T> {
    T selectByID(int id);

    public void createTable();
}
