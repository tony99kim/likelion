package jdbc03;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeptDaoImpl implements DeptDao {
    private final JdbcTemplate jdbcTemplate;

    public DeptDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertDept(Dept dept) {
        String sql = "INSERT INTO dept (dname, loc) VALUES (?, ?)";
        return jdbcTemplate.update(sql, dept.getDname(), dept.getLoc());
    }

    @Override
    public List<Dept> findAllDepts() {
        String sql = "SELECT deptno, dname, loc FROM dept ORDER BY deptno";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Dept dept = new Dept();
            dept.setDeptno(rs.getInt("deptno"));
            dept.setDname(rs.getString("dname"));
            dept.setLoc(rs.getString("loc"));
            return dept;
        });
    }

    @Override
    public Dept findDeptByDeptno(int deptno) {
        String sql = "SELECT deptno, dname, loc FROM dept WHERE deptno = ?";

        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));
                return dept;
            }, deptno);
        } catch (EmptyResultDataAccessException e) {
            throw new DeptNotFoundException(deptno);
        }
    }

    @Override
    public int updateDept(Dept dept) {
        String sql = "UPDATE dept SET dname = ?, loc = ? WHERE deptno = ?";
        int result = jdbcTemplate.update(sql, dept.getDname(), dept.getLoc(), dept.getDeptno());

        if (result == 0) {
            throw new DeptNotFoundException(dept.getDeptno());
        }

        return result;
    }

    @Override
    public int deleteDept(int deptno) {
        String sql = "DELETE FROM dept WHERE deptno = ?";
        int result = jdbcTemplate.update(sql, deptno);

        if (result == 0) {
            throw new DeptNotFoundException(deptno);
        }

        return result;
    }
}