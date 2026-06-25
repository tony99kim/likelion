package jdbc03;

import java.util.List;

public interface DeptDao {
    int insertDept(Dept dept);

    List<Dept> findAllDepts();

    Dept findDeptByDeptno(int deptno);

    int updateDept(Dept dept);

    int deleteDept(int deptno);
}