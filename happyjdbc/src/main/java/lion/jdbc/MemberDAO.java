package lion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//DAO - data access object
//DTO   -- VO(Value Object)
public class MemberDAO {
    public boolean insertMember(MemberDTO memberDTO){
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "lion";
        String password = "lion1234";

        String sql = "insert into member(name,email, password) values(?,?,?)";

        boolean result = false;
        try(Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1,memberDTO.getName());
            ps.setString(2,memberDTO.getEmail());
            ps.setString(3,memberDTO.getPassword());
            int count = ps.executeUpdate();
            if(count == 1)
                result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
    //수정
    public int updateMember(MemberDTO memberDTO){
        int resultCount = 0;




        return resultCount;
    }

    //삭제
    

    //조회 (한건 조회)

    //조회 (여러건 조회)
}
