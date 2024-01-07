package ru.flanker;

import ru.flanker.domain.Country;

/**
 * @author 1ommy
 * @version 07.01.2024
 */
public class Main {
    public static void main(String[] args) {
        try (
                var sessionFactory = HibernateUtil.getSessionFactory();
                var session = sessionFactory.openSession()
        ) {
            session.beginTransaction();


            var country = Country.builder()
                    .title("Russia")
                    .population(145000000)
                    .build();

            session.save(country);

            session.getTransaction().commit();
        }
    }
}