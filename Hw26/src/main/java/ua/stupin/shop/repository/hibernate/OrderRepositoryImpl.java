package ua.stupin.shop.repository.hibernate;

import ua.stupin.shop.config.HibernateUtils;
import ua.stupin.shop.entity.Order;
import ua.stupin.shop.repository.OrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl extends AbstractHibernateRepository<Order> implements OrderRepository {
    protected void init() {
        aClass = Order.class;
    }

    @Override
    public List<Order> getOrdersWithDiscount() {
        List<Order> orderList = new ArrayList<>();
        EntityManager entityManager = HibernateUtils.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> query = criteriaBuilder.createQuery(aClass);
        Root<Order> from = query.from(aClass);
        query.select(from).where(criteriaBuilder.greaterThan(from.get("discount"), 0));
        entityManager.createQuery(query).getResultList();
        return entityManager.createQuery(query).getResultList();
    }
}