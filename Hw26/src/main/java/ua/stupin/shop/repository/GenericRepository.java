package ua.stupin.shop.repository;

import ua.stupin.shop.entity.Order;

import java.util.List;

public interface GenericRepository<T> {
    T getById(String id);

    List<T> getAll();

    void save(T client);

}