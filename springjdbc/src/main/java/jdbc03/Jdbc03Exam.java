package jdbc03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Jdbc03Exam implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Jdbc03Exam.class, args);
    }

    @Autowired
    private DeptDao deptDao;

    @Override
    public void run(String... args) {
        try {
            Dept dept = new Dept();
            dept.setDname("개발팀");
            dept.setLoc("서울");

            int insertResult = deptDao.insertDept(dept);
            System.out.println("insert 결과: " + insertResult);

            List<Dept> depts = deptDao.findAllDepts();
            System.out.println("전체 부서 목록");
            for (Dept d : depts) {
                System.out.println(d);
            }

            Dept findDept = deptDao.findDeptByDeptno(1);
            System.out.println("deptno 1 조회 결과: " + findDept);

            findDept.setDname("인사팀");
            findDept.setLoc("부산");

            int updateResult = deptDao.updateDept(findDept);
            System.out.println("update 결과: " + updateResult);

            Dept updatedDept = deptDao.findDeptByDeptno(findDept.getDeptno());
            System.out.println("수정 후 조회 결과: " + updatedDept);

        } catch (DeptNotFoundException e) {
            System.out.println("부서 조회 실패: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("알 수 없는 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}