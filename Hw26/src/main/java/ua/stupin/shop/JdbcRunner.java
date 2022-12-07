package ua.stupin.shop;

import ua.stupin.shop.entity.Client;
import ua.stupin.shop.entity.Goods;
import ua.stupin.shop.entity.Order;
import ua.stupin.shop.repository.ClientRepository;
import ua.stupin.shop.repository.GoodsRepository;
import ua.stupin.shop.repository.OrderRepository;
import ua.stupin.shop.repository.jdbc.ClientRepositoryImpl;
import ua.stupin.shop.repository.jdbc.GoodsRepositoryImpl;
import ua.stupin.shop.repository.jdbc.OrderRepositoryImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class JdbcRunner {
    private static final ClientRepository clientRepository = new ClientRepositoryImpl();
    private static final GoodsRepository goodsRepository = new GoodsRepositoryImpl();
    private static final OrderRepository orderRepository = new OrderRepositoryImpl(goodsRepository, clientRepository);

    public static void main(String[] args) {
        Client client = createAndSaveClient();
        clientRepository.getAll().forEach(System.out::println);
        Goods goods = createAndSaveGoods();
        goodsRepository.getAll().forEach(System.out::println);
        Order order = createAndSaveOrder(client, goods);
        orderRepository.getAll().forEach(System.out::println);
        System.out.println("Orders with discount:");
        orderRepository.getOrdersWithDiscount().forEach(System.out::println);
        int numberOfOrders = 2;
        System.out.println("Clients with amount of orders greater then:" + numberOfOrders);
        clientRepository.getClientsWithAmountOfOrdersGreater(numberOfOrders).forEach(System.out::println);
        int age = 2;
//        Не видаляє бо каскадне видалення не працює
//        clientRepository.removeAllClientsYoungerThan(age);
    }

    private static Client createAndSaveClient() {
        Client client = new Client(UUID.randomUUID().toString(), "Tester", "Testerov2", LocalDate.of(2022, 11, 29), Collections.emptyList());
        clientRepository.save(client);
        List<Client> clientList = clientRepository.getAll();
        client = clientList.get(clientList.size() - 1);
        return client;
    }

    private static Goods createAndSaveGoods() {
        Goods goods = new Goods(UUID.randomUUID().toString(), BigDecimal.valueOf(2000), "Test goods", "Test category", List.of());
        goodsRepository.save(goods);
        List<Goods> goodsList = goodsRepository.getAll();
        return goodsList.get(goodsList.size() - 1);
    }

    private static Order createAndSaveOrder(Client client, Goods goods) {
        Order order = new Order(UUID.randomUUID().toString(), LocalDateTime.now(), goods.getPrice(), 5, client, List.of(goods));
        orderRepository.save(order);
        List<Order> orderList = orderRepository.getAll();
        return orderList.get(orderList.size() - 1);
    }
}