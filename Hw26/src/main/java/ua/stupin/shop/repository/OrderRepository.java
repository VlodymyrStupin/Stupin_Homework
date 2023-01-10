package ua.stupin.shop.repository;


import ua.stupin.shop.entity.Order;

import java.util.List;

public interface OrderRepository extends GenericRepository<Order> {
    List<Order> getOrdersWithDiscount();
}
