package market.dao;

import market.common.DBUtil;
import market.dto.ProductDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {


    @Override
    public int insertProduct(Connection conn, ProductDTO productDTO) throws SQLException {
        String sql = "insert into product(title,price,status) values(?,?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,productDTO.getTitle());
            ps.setInt(2,productDTO.getPrice());
            ps.setString(3,productDTO.getStatus());
            return ps.executeUpdate();
        }
    }

    @Override
    public ProductDTO getProduct(Connection conn, long productId) throws SQLException {
      String sql = "select product_id,title,price,status,created_at from product where product_id = ?";
      try(PreparedStatement ps = conn.prepareStatement(sql)){
          ps.setLong(1,productId);

          try(ResultSet rs = ps.executeQuery()){
              if(rs.next()){
                  ProductDTO productDTO = new ProductDTO();
                  productDTO.setProductId(rs.getLong("product_id"));
                  productDTO.setTitle(rs.getString("title"));
                  productDTO.setPrice(rs.getInt("price"));
                  productDTO.setStatus(rs.getString("status"));
                  productDTO.setCreateAt(rs.getObject("created_at", LocalDateTime.class));

                  return productDTO;
              }

          }
      }
      return null;
    }

    @Override
    public List<ProductDTO> getProducts(Connection conn) throws SQLException {
        String sql = "select product_id,title,price,status,created_at from product";
        List<ProductDTO> products = new ArrayList<>();

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ProductDTO productDTO = new ProductDTO();
                productDTO.setProductId(rs.getLong("product_id"));
                productDTO.setTitle(rs.getString("title"));
                productDTO.setPrice(rs.getInt("price"));
                productDTO.setStatus(rs.getString("status"));
                productDTO.setCreateAt(rs.getObject("created_at", LocalDateTime.class));

                products.add(productDTO);
            }
        }
        return products;
    }

    @Override
    public int updateProductStatus(Connection conn, long productId, String status) throws SQLException {
        String sql = "update product set status = ? where product_id = ?";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,status);
            ps.setLong(2,productId);
            return ps.executeUpdate();
        }
    }

    @Override
    public int deleteProduct(Connection conn, long productId) throws SQLException {
       String sql = "delete from product where product_id = ?";

       try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setLong(1,productId);
            return ps.executeUpdate();
        }
    }
}
