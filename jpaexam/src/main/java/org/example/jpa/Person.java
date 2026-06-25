package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persons")
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL,orphanRemoval = true)
    private Passport passport;


    public void setPerson(Person person) {

    }
}
