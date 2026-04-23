package market.dao;

import market.dto.ProductDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    int insertProduct(Connection conn, ProductDTO productDTO) throws SQLException;
    ProductDTO getProduct(Connection conn, long productId) throws SQLException;
    List<ProductDTO> getProducts(Connection conn) throws SQLException;
    int updateProductStatus(Connection conn, long productId, String status) throws SQLException;
    int deleteProduct(Connection conn, long productId) throws SQLException;
}