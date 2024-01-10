package ru.flanker.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author 1ommy
 * @version 10.01.2024
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@Table(name = "languages")
@ToString
@Entity
public class Languages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String language;

}
