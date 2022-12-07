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
        Query query = session.createSQLQuery("SELECT clients.client_id, clients.first_name, clients.last_name, " +
                "clients.date_of_birth FROM clients LEFT OUTER JOIN orders ON clients.client_id " +
                "= orders.client_id GROUP BY clients.client_id HAVING COUNT(*) > :amount").addEntity(aClass);
        clientList = (List<Client> ) query.setParameter("amount", amount).list();
        session.getTransaction().commit();

        return clientList;
    }

    public int removeAllClientsYoungerThan(int age) {
        Session session = null;
        session = HibernateUtils.getFactory().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("DELETE FROM clients WHERE (SELECT YEAR (CURDATE()) - " +
                "YEAR (clients.date_of_birth)) < :age ").addEntity(aClass);
        query.setParameter("age", age);
        session.getTransaction().commit();
        return age;
    }
}