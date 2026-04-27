package market;

import market.dto.ProductDTO;
import market.service.MarketService;
import market.service.MarketServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MarketApplication {

    private static final MarketService marketService = new MarketServiceImpl();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while (run) {
            printMenu();
            System.out.print("선택 > ");
            String menu = sc.nextLine();

            switch (menu) {
                case "1" -> createProduct(sc);
                case "2" -> getProduct(sc);
                case "3" -> getProducts();
                case "4" -> buyProduct(sc);
                case "5" -> deleteProduct(sc);
                case "0" -> {
                    System.out.println("프로그램을 종료합니다.");
                    run = false;
                }
                default -> System.out.println("잘못된 메뉴입니다.");
            }
        }

        sc.close();
    }

    private static void printMenu() {
        System.out.println("==================================");
        System.out.println("1. 상품 등록");
        System.out.println("2. 상품 조회");
        System.out.println("3. 전체 상품 조회");
        System.out.println("4. 상품 구매");
        System.out.println("5. 상품 삭제");
        System.out.println("0. 종료");
        System.out.println("==================================");
    }

    private static void createProduct(Scanner sc) {
        System.out.println("상품 등록을 취소하려면 각 입력에서 '취소'를 입력하세요.");

        System.out.print("상품명 > ");
        String title = sc.nextLine();
        if ("취소".equals(title)) {
            System.out.println("상품 등록을 취소하고 메인 메뉴로 돌아갑니다.");
            return;
        }

        Integer price = inputIntegerOrCancel(sc, "가격 > ");
        if (price == null) {
            return;
        }

        System.out.print("상태 > ");
        String status = sc.nextLine();
        if ("취소".equals(status)) {
            System.out.println("상품 등록을 취소하고 메인 메뉴로 돌아갑니다.");
            return;
        }

        boolean result = marketService.createProduct(title, price, status);
        if (result) {
            System.out.println("상품 등록 성공");
        } else {
            System.out.println("상품 등록 실패");
        }
    }

    private static void getProduct(Scanner sc) {
        Long productId = inputLongOrCancel(sc, "상품 번호 > ");
        if (productId == null) {
            return;
        }

        ProductDTO productDTO = marketService.getProduct(productId);

        if (productDTO == null) {
            System.out.println("상품없음");
            return;
        }

        printProductHeader();
        printProductRow(productDTO);
    }

    private static void getProducts() {
        List<ProductDTO> products = marketService.getProducts();

        if (products.isEmpty()) {
            System.out.println("상품없음");
            return;
        }

        printProductHeader();
        for (ProductDTO product : products) {
            printProductRow(product);
        }
    }

    private static void buyProduct(Scanner sc) {
        Long productId = inputLongOrCancel(sc, "구매할 상품 번호 > ");
        if (productId == null) {
            return;
        }

        boolean result = marketService.buyProduct(productId);
        if (result) {
            System.out.println("구매 완료");
        } else {
            System.out.println("구매 실패");
        }
    }

    private static void deleteProduct(Scanner sc) {
        Long productId = inputLongOrCancel(sc, "삭제할 상품 번호 > ");
        if (productId == null) {
            return;
        }

        boolean result = marketService.deleteProduct(productId);
        if (result) {
            System.out.println("삭제 완료");
        } else {
            System.out.println("삭제 실패");
        }
    }

    private static void printProductHeader() {
        System.out.printf("%-10s %-20s %-10s %-10s %-20s%n",
                "상품번호", "상품명", "가격", "상태", "등록일");
        System.out.println("---------------------------------------------------------------------");
    }

    private static void printProductRow(ProductDTO product) {
        System.out.printf("%-10d %-20s %-10d %-10s %-20s%n",
                product.getProductId(),
                product.getTitle(),
                product.getPrice(),
                product.getStatus(),
                product.getCreateAt());
    }

    private static Long inputLongOrCancel(Scanner sc, String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine();

        if ("취소".equals(input)) {
            System.out.println("메인 메뉴로 돌아갑니다.");
            return null;
        }

        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력하세요.");
            return null;
        }
    }

    private static Integer inputIntegerOrCancel(Scanner sc, String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine();

        if ("취소".equals(input)) {
            System.out.println("메인 메뉴로 돌아갑니다.");
            return null;
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력하세요.");
            return null;
        }
    }
}