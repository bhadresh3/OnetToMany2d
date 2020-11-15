package com.system27.OnetToMany2d.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
public class Person {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(nullable = false)
    private String name;

    @Column
    private String likes;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Car> cars;

}
