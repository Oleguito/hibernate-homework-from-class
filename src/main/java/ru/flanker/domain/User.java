package ru.flanker.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author 1ommy
 * @version 10.01.2024
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@Table(name = "users")
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "full_name")
    private String fullName;

    @ManyToOne
//    @JoinColumn(name = "country_id")
    private Country country;


    @ManyToMany
    @JoinTable(
            name = "users_languages",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Languages> languages;
}
