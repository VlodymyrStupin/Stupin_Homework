package ua.stupin.hw24;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

   static {
       try {
           sessionFactory = new Configuration().configure().buildSessionFactory();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}


