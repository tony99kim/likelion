package lion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteExam {
    public static void main(String[] args) throws Exception{
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/hrdb";
        String user = "hr";
        String password = "hr";
        conn = DriverManager.getConnection(url,user,password);
        String sql = "delete from member where name = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "kkk");

        int result = ps.executeUpdate();
        System.out.println(result+"건 삭제됨");
        conn.close();
    }
}