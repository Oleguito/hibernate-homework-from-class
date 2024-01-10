package ru.flanker;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.flanker.domain.Advertisement;
import ru.flanker.domain.Country;
import ru.flanker.domain.Languages;
import ru.flanker.domain.User;

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
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Advertisement.class)
                    .addAnnotatedClass(Languages.class)
                    .configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
