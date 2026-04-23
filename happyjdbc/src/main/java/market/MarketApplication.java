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
        System.out.print("상품명 > ");
        String title = sc.nextLine();

        System.out.print("가격 > ");
        int price = Integer.parseInt(sc.nextLine());

        System.out.print("상태 > ");
        String status = sc.nextLine();

        boolean result = marketService.createProduct(title, price, status);
        if (result) {
            System.out.println("상품 등록 성공");
        } else {
            System.out.println("상품 등록 실패");
        }
    }

    private static void getProduct(Scanner sc) {
        System.out.print("상품 번호 > ");
        long productId = Long.parseLong(sc.nextLine());

        ProductDTO productDTO = marketService.getProduct(productId);

        if (productDTO == null) {
            System.out.println("상품없음");
        } else {
            System.out.println(productDTO);
        }
    }

    private static void getProducts() {
        List<ProductDTO> products = marketService.getProducts();

        if (products.isEmpty()) {
            System.out.println("상품없음");
        } else {
            for (ProductDTO product : products) {
                System.out.println(product);
            }
        }
    }

    private static void buyProduct(Scanner sc) {
        System.out.print("구매할 상품 번호 > ");
        long productId = Long.parseLong(sc.nextLine());

        boolean result = marketService.buyProduct(productId);
        if (result) {
            System.out.println("구매 완료");
        } else {
            System.out.println("구매 실패");
        }
    }

    private static void deleteProduct(Scanner sc) {
        System.out.print("삭제할 상품 번호 > ");
        long productId = Long.parseLong(sc.nextLine());

        boolean result = marketService.deleteProduct(productId);
        if (result) {
            System.out.println("삭제 완료");
        } else {
            System.out.println("삭제 실패");
        }
    }
}