package org.example.restapitask.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public static Role user(){
        return Role.builder()
                .name("USER")
                .build();
    }

    public static Role admin(){
        return Role.builder()
                .name("ADMIN")
                .build();
    }
}
