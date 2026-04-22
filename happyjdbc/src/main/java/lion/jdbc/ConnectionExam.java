package lion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionExam {
    public static void main(String[] args) throws Exception{
//        DB에 접속이 필요하다!!  -- 접속이 추상화된 객체 Connection
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "lion";
        String password = "lion1234";
        conn = DriverManager.getConnection(url,user,password);

        if(conn != null)
            System.out.println("^^");
        else
            System.out.println("-_-;;");


        conn.close();
    }

}
