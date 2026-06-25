package jdbc03;

public class DeptNotFoundException extends RuntimeException {
    public DeptNotFoundException(int deptno) {
        super("해당 부서를 찾을 수 없습니다. deptno = " + deptno);
    }
}