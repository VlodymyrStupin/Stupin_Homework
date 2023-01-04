package ua.stupin.shop.repository.hibernate;

import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.stupin.shop.config.HibernateUtils;
import ua.stupin.shop.entity.Client;
import ua.stupin.shop.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryImpl extends AbstractHibernateRepository<Client> implements ClientRepository {
    private final String getClientsWithAmountOfOrdersGreater = "SELECT * FROM clients LEFT JOIN orders on clients.client_id " +
            "= orders.client_id GROUP BY clients.client_id HAVING COUNT(*) > ?";
    private final String removeAllClientsYoungerThan = "DELETE FROM clients WHERE ((YEAR (NOW()) - YEAR(date_of_birth))< ?)";
    private final String getClientsWithSumOfOrdersGreaterAndAmountOfGoodsInOrderGreater = "SELECT clients.client_id,  clients.date_of_birth, clients.first_name, clients.last_name, orders.order_id\n" +
            "FROM clients \n" +
            "INNER JOIN orders \n" +
            "ON clients.client_id = orders.client_id \n" +
            "GROUP BY clients.client_id \n" +
            "HAVING orders.order_id IN\n" +
            "(SELECT orders.order_id\n" +
            "FROM orders\n" +
            "INNER JOIN orders_goods\n" +
            "ON orders.order_id = orders_goods.order_id\n" +
            "GROUP BY orders.order_id\n" +
            "HAVING COUNT(orders_goods.goods_id) > ?)\n" +
            "AND\n" +
            "SUM(orders.total_price) > ?;";

    protected void init() {
        aClass = Client.class;
    }

    @SneakyThrows
    @Override
    public List<Client> getClientsWithAmountOfOrdersGreater(int amount) {
        Session session = null;
        List<Client> clientList = new ArrayList<>();
        session = HibernateUtils.getFactory().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery(getClientsWithAmountOfOrdersGreater + amount).addEntity(aClass);
        query.setParameter(1, amount);
        clientList = query.list();
        session.getTransaction().commit();
        session.close();
        return clientList;
    }

    @Override
    @SneakyThrows
    public void removeAllClientsYoungerThan(int age) {
        Session session = null;
        session = HibernateUtils.getFactory().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery(removeAllClientsYoungerThan).addEntity(aClass);
        query.setParameter(1, age);
        session.getTransaction().commit();
        session.close();
    }

    public List<Client> getClientsWithSumOfOrdersGreaterAndAmountOfGoodsInOrderGreater(int amountOfOrders, int goodsLimit) {
        Session session = null;
        List<Client> clientList = new ArrayList<>();
        session = HibernateUtils.getFactory().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery(getClientsWithSumOfOrdersGreaterAndAmountOfGoodsInOrderGreater).addEntity(aClass);
        query.setParameter(1, goodsLimit);
        query.setParameter(2, amountOfOrders);
        clientList = query.list();
        session.getTransaction().commit();
        session.close();
        return clientList;
    }
}
