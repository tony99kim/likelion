package org.example.aopexam.auditable;

import com.example.aop.context.UserContext;
import com.example.aop.domain.User;
import com.example.aop.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AuditTestApp {

    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(AuditTestApp.class, args);

        ProductService productService = context.getBean(ProductService.class);

        // 사용자 설정
        User admin = new User(1L, "admin", "ADMIN");
        UserContext.setCurrentUser(admin);

        System.out.println("\n=== 감사 로그 테스트 ===\n");

        // 테스트 1: 상품 생성 (성공)
        String productId = productService.createProduct("노트북", 1500000);
        System.out.println("생성된 상품 ID: " + productId + "\n");

        // 테스트 2: 가격 변경 (성공)
        productService.updatePrice(productId, 1500000, 1350000);
        System.out.println();

        // 테스트 3: 재고 변경 (성공)
        int newStock = productService.updateStock(productId, 50);
        System.out.println("새로운 재고: " + newStock + "\n");

        // 테스트 4: 상품 삭제 (실패 케이스)
        try {
            productService.deleteProduct(null);
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        System.out.println();

        // 테스트 5: 상품 삭제 (성공)
        productService.deleteProduct(productId);

        UserContext.clear();
    }
}
