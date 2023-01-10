package ua.stupin.shop;

import ua.stupin.shop.entity.Client;
import ua.stupin.shop.entity.Goods;
import ua.stupin.shop.entity.Order;
import ua.stupin.shop.repository.ClientRepository;
import ua.stupin.shop.repository.GoodsRepository;
import ua.stupin.shop.repository.OrderRepository;
import ua.stupin.shop.repository.hibernate.ClientRepositoryImpl;
import ua.stupin.shop.repository.hibernate.GoodsRepositoryImpl;
import ua.stupin.shop.repository.hibernate.OrderRepositoryImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class HibernateRunner {
    private static final ClientRepository clientRepository = new ClientRepositoryImpl();
    private static final GoodsRepository goodsRepository = new GoodsRepositoryImpl();
    private static final OrderRepository orderRepository = new OrderRepositoryImpl();

    public static void main(String[] args) {
        Client client = createAndSaveClient();
        clientRepository.getAll().forEach(System.out::println);
        Goods goods = createAndSaveGoods();
        goodsRepository.getAll().forEach(System.out::println);
        Order order = createAndSaveOrder(client, goods);
        orderRepository.getAll().forEach(System.out::println);
        System.out.println("Orders with discount:");
        orderRepository.getOrdersWithDiscount().forEach(System.out::println);
        int amount = 1;
        System.out.println("Clients with amount of orders greater:");
        clientRepository.getClientsWithAmountOfOrdersGreater(amount).forEach(System.out::println);
        int age = 20;
        clientRepository.removeAllClientsYoungerThan(age);
        int amountOfOrders = 10000;
        int goodsLimit = 0;
        clientRepository.getClientsWithSumOfOrdersGreaterAndAmountOfGoodsInOrderGreater(amountOfOrders, goodsLimit)
                .forEach(System.out::println);
    }

    private static Client createAndSaveClient() {
        Client client = new Client("Testerik", "Testerov", LocalDate.of(2020, 11, 29));
        clientRepository.save(client);
        return client;
    }

    private static Goods createAndSaveGoods() {
        Goods goods = new Goods(BigDecimal.valueOf(2000), "Test goods", "Test category");
        goodsRepository.save(goods);
        return goods;
    }

    private static Order createAndSaveOrder(Client client, Goods goods) {
        Order order = new Order(LocalDateTime.now(), goods.getPrice(), 0);
        order.setGoods(List.of(goods));
        order.setClient(client);
        orderRepository.save(order);
        return order;
    }
}