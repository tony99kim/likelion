package day11;

public class Exception1 {
    public static void main(String[] args) {
        ExceptionObj1 exobj = new ExceptionObj1();
        int value = exobj.divide(10, 0);
        System.out.println(value);
    }
}

class ExceptionObj1 {
    public int divide(int i, int k) {
        int value = 0;
        try {
            value = i / k;
        } catch(ArithmeticException ex) {
            System.out.println("0으로 나눌 수 없습니다.");
        }
        return value;
    }
}
