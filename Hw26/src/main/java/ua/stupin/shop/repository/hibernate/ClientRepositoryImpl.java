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
        return clientList;
    }

    public int removeAllClientsYoungerThan(int age) {
        Session session = null;
        session = HibernateUtils.getFactory().openSession();
        session.beginTransaction();
        Query dropForeignKeyQuery = session.createSQLQuery("ALTER TABLE orders DROP FOREIGN KEY FKaoqjqu5li3448xo657dvp6teq");
        Query query = session.createQuery("DELETE clients WHERE (YEAR (NOW()) - YEAR(date_of_birth) < :age)");
        query.setParameter("age", age);
//        dropForeignKeyQuery.executeUpdate();
        int result = query.executeUpdate();
        session.getTransaction().commit();
        return result;
    }
    public List<Client> getClientsWithSumOfOrdersGreaterAndAmountOfGoodsInOrderGreater(int amountOfOrders, int goodsLimit){
        List<Client> clientList = new ArrayList<>();
        return clientList;
    }
}