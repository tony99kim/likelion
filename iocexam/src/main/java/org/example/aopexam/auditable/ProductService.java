package org.example.aopexam.auditable;

import org.example.aopexam.auditable.Auditable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Auditable(action = "상품 생성")
    public String createProduct(String productName, int price) {
        System.out.println("상품 생성: " + productName + ", 가격: " + price);
        return "Product-" + System.currentTimeMillis();
    }

    @Auditable(action = "상품 가격 변경")
    public void updatePrice(String productId, int oldPrice, int newPrice) {
        System.out.println(String.format(
                "상품 %s 가격 변경: %d -> %d", productId, oldPrice, newPrice
        ));
    }

    @Auditable(action = "상품 삭제")
    public void deleteProduct(String productId) {
        if (productId == null || productId.isEmpty()) {
            throw new IllegalArgumentException("상품 ID는 필수입니다");
        }
        System.out.println("상품 삭제: " + productId);
    }

    @Auditable(action = "재고 변경")
    public int updateStock(String productId, int quantity) {
        System.out.println(String.format(
                "상품 %s 재고 변경: %d개 추가", productId, quantity
        ));
        return 100 + quantity;
    }
}
