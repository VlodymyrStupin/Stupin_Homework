package ua.stupin.shop.repository;


import ua.stupin.shop.entity.Client;

import java.util.List;

public interface ClientRepository extends GenericRepository<Client> {
    List<Client> getClientsWithAmountOfOrdersGreater(int amount);

    void removeAllClientsYoungerThan(int age);

    List<Client> getClientsWithSumOfOrdersGreaterAndAmountOfGoodsInOrderGreater(int amountOfOrders, int goodsLimit);
}