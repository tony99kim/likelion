package market.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/hrdb";
    private static final String USER = "hr";
    private static final String PASSWORD = "hr";

//    CREATE TABLE product (
//    product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
//    title VARCHAR(100) NOT NULL,
//    price INT NOT NULL,
//    status VARCHAR(20) NOT NULL DEFAULT '판매중',
//    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
//    );

    private DBUtil() {
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
