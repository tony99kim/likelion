package org.example.restexam.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.restexam.dto.ProductDTO;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100)
    private String name;
    private int price;

    //DTO -> Entity로 변환하는 메서드
    public static Product fromDTO(ProductDTO DTO) {
        return Product.builder()
                .id(DTO.getId())
                .name(DTO.getName())
                .price(DTO.getPrice())
                .build();
    }
}
