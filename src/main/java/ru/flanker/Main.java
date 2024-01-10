package ru.flanker;

import jakarta.persistence.criteria.CriteriaBuilder;
import ru.flanker.domain.User;

import java.util.List;

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



            /*var country = Country.builder()
                    .title("USA")
                    .population(405000000)
                    .build();

            session.persist(country);*/
//            var language = ;
//            session.persist(language);

         /*   var user = User.builder()
                    .country(session.get(Country.class, 4))
                    .fullName("Alex Maksimov")
                    .userName("alexmaksimov")
                    .languages(List.of(
                            session.get(Languages.class, 1),
                            Languages.builder().id(2).language("китайский").build()
                    ))
                    .build();
            session.persist(user);*/

//            session.remove(session.get(Country.class, 1));
            CriteriaBuilder cb = session.getCriteriaBuilder();

            /*Country country = session.get(Country.class, 2);

            var criteriaQuery = cb.createQuery(User.class);

            var baseClass = criteriaQuery.from(User.class);


            criteriaQuery.select(baseClass).where(
                    cb.and(
                            cb.equal(baseClass.get("country").get("id"), country.getId())
                    )
            );


            Query<User> query = session.createQuery(criteriaQuery);

            List<User> results = query.getResultList();*/
//            results.stream().forEach((user) -> {
//            });
//            var country = results.get(0);
//            country.getUsers().forEach(System.out::println);

//            User user = session.get(User.class, 1);
//            System.out.println(user);

            List<User> list = session.createQuery("from User u join Country c on c.id=u.country.id")
                    .list();
            list.stream().forEach((user -> {
                System.out.println(user.getCountry().getTitle());
            }));

            session.getTransaction().commit();
        }
    }
}