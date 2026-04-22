package lion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateExam {
    public static void main(String[] args) throws Exception{
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/hrdb";
        String user = "hr";
        String password = "hr";
        conn = DriverManager.getConnection(url,user,password);

        String sql = "update member set name = ? ,email = ? where id = ?";
        PreparedStatement ps =conn.prepareStatement(sql);
        ps.setString(1, "훈이");
        ps.setString(2,"훈이@gmail.com");
        ps.setInt(3,1);

        int result = ps.executeUpdate();

        System.out.println(result+"건 입렵됨");
        conn.close();
    }

}