package ua.stupin.shop.repository.hibernate;


import ua.stupin.shop.config.HibernateUtils;
import ua.stupin.shop.entity.Order;
import ua.stupin.shop.repository.GenericRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHibernateRepository<T> implements GenericRepository<T> {
    protected Class<T> aClass;

    public AbstractHibernateRepository() {
        init();
    }

    protected abstract void init();

    @Override
    public T getById(String id) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(aClass);
        Root<T> from = query.from(aClass);
        query.select(from).where(criteriaBuilder.equal(from.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public List<T> getAll() {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(aClass);
        Root<T> from = query.from(aClass);
        query.select(from);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void save(T value) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(value);
        entityManager.flush();
        transaction.commit();
    }
}