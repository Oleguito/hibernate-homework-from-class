package ru.flanker;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.flanker.domain.Country;

/**
 * @author 1ommy
 * @version 07.01.2024
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration()
                    .addAnnotatedClass(Country.class)
                    .configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
