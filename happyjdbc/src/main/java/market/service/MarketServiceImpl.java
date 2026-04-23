package market.service;

import market.common.DBUtil;
import market.dao.ProductDAO;
import market.dao.ProductDAOImpl;
import market.dto.ProductDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MarketServiceImpl implements MarketService {

    private final ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public boolean createProduct(String title, int price, String status) {
        try (Connection conn = DBUtil.getConnection()) {
            ProductDTO productDTO = new ProductDTO(title, price, status);
            return productDAO.insertProduct(conn, productDTO) == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public ProductDTO getProduct(long productId) {
        try (Connection conn = DBUtil.getConnection()) {
            return productDAO.getProduct(conn, productId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<ProductDTO> getProducts() {
        try (Connection conn = DBUtil.getConnection()) {
            return productDAO.getProducts(conn);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return List.of();
        }
    }

    @Override
    public boolean buyProduct(long productId) {
        try (Connection conn = DBUtil.getConnection()) {
            ProductDTO productDTO = productDAO.getProduct(conn, productId);

            if (productDTO == null) {
                System.out.println("해당 상품이 존재하지 않습니다.");
                return false;
            }

            if (!"판매중".equals(productDTO.getStatus())) {
                System.out.println("이미 판매완료된 상품입니다.");
                return false;
            }

            return productDAO.updateProductStatus(conn, productId, "판매완료") == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteProduct(long productId) {
        try (Connection conn = DBUtil.getConnection()) {
            return productDAO.deleteProduct(conn, productId) == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}