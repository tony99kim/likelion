package org.example.restexam.service;

import lombok.RequiredArgsConstructor;
import org.example.restexam.domain.Product;
import org.example.restexam.dto.ProductDTO;
import org.example.restexam.repository.ProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    //상품추가
    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO) {
//        dto로 들고온 값을 엔티티로 바꿔야한다
//        Product product = Product.builder()
//                .name(productDTO.getName())
//                .price(productDTO.getPrice())
//                .build();

        Product saveProduct = repository.save(Product.fromDTO(productDTO));
        // 엔티티에 들어 있는 값을 dto에 옮겨 담아햐한다.
        return ProductDTO.fromEntity(saveProduct);
    }
}
