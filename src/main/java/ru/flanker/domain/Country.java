package ru.flanker.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

/**
 * @author 1ommy
 * @version 07.01.2024
 */

@Entity
@Table(name = "country")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Country {
    @Id
//    @SequenceGenerator(name = "county_seq",
//            sequenceName = "county_sequence",
//            initialValue = 1, allocationSize = 20) // create sequence county_seq with initial value 1 increment 20
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
    AUTO зависит от БД
    Если в базе нет последовательностей (MYSQL), то он делает TABLE:
        при TABLE у нас создается отдельная таблица для хранения ID
        select max_id() from other_table;
        при вставке мы идем в эту таблицу,берем оттуда максимальный ID и инкрементируем его
    Если в базе есть последовательность,то он ставит SEQUENCE:

    пример запроса для identity:
    select max_id() from our table;
    increment();
    insert();

    пример запроса для sequence generator allocatorSize=1:
    select nextval('sequence_name');
    insert();
    select nextval('sequence_name');
    insert();
    select nextval('sequence_name');
    insert();
    select nextval('sequence_name');
    insert();
    select nextval('sequence_name');
    insert();
    select nextval('sequence_name');
    insert();
    select nextval('sequence_name');
    insert();
    select nextval('sequence_name');
    insert();
    select nextval('sequence_name');
    insert();
    select nextval('sequence_name');
    insert();
    select nextval('sequence_name');
    insert();
    select nextval('sequence_name');
    insert();

    пример для allocatorSize=5
    select nextval('sequence_name');
    insert();
    insert();
    insert();
    insert();
    insert();
     */
    private Integer id;
    // countries

    //    @Column(name="TITLE", nullable = false)
    private String title;

    private Integer population;

    @OneToMany(mappedBy = "country")
    // @Fetch(FetchMode.JOIN)
    @ToString.Exclude
//    @JoinColumn(name = "country_id")
    private Set<User> users;


//    private Integer amountOfMoney;

}
