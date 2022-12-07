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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
        int amount = 2;
        System.out.println("Clients with amount of orders greater:");
        System.out.println(clientRepository.getClientsWithAmountOfOrdersGreater(amount));
        int age = 20;
        clientRepository.removeAllClientsYoungerThan(age);
    }

    private static Client createAndSaveClient() {
        Client client = new Client("Tester", "Testerov", LocalDate.of(2001, 11, 29));
        clientRepository.save(client);
        List<Client> clientList = clientRepository.getAll();
        client = clientList.get(clientList.size() - 1);
        return client;
    }

    private static Goods createAndSaveGoods() {
        Goods goods = new Goods(BigDecimal.valueOf(2000), "Test goods", "Test category");
        goodsRepository.save(goods);
        List<Goods> goodsList = goodsRepository.getAll();
        return goodsList.get(goodsList.size() - 1);
    }

    private static Order createAndSaveOrder(Client client, Goods goods) {
        Order order = new Order(LocalDateTime.now(), goods.getPrice(), null);
        order.setGoods(List.of(goods));
        order.setClient(client);
        orderRepository.save(order);
        List<Order> orderList = orderRepository.getAll();
        return orderList.get(orderList.size() - 1);
    }
}