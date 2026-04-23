package market.service;

import market.dto.ProductDTO;

import java.util.List;

public interface MarketService {
    boolean createProduct(String title, int price, String status);
    ProductDTO getProduct(long productId);
    List<ProductDTO> getProducts();
    boolean buyProduct(long productId);
    boolean deleteProduct(long productId);
}
