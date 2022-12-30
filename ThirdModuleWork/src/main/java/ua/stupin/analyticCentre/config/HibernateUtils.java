package ua.stupin.analyticCentre.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.stupin.analyticCentre.entities.Device;
import ua.stupin.analyticCentre.entities.Subscriber;
import ua.stupin.analyticCentre.entities.Tariff;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class HibernateUtils {
    private static SessionFactory factory;
    private static EntityManager entityManager;

    private static void configureFactory() {
        try {
            factory = new Configuration()
                    .addAnnotatedClass(Device.class)
                    .addAnnotatedClass(Subscriber.class)
                    .addAnnotatedClass(Tariff.class)
                    .configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static void configureEntityManager() {
        EntityManagerFactory factory = createEntityManagerFactory("jdbc-hiber");
        entityManager = factory.createEntityManager();
    }

    public static SessionFactory getFactory() {
        if (factory == null) {
            configureFactory();
        }
        return factory;
    }

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            configureEntityManager();
        }
        return entityManager;
    }
}