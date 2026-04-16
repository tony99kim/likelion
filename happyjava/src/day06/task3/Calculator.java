package day06.task3;

public class Calculator {
    private int result;
    private int a;
    private int b;

    public void add(int a, int b){
        result = a + b;
        System.out.println("더하기 결과:"+result);
    }

    public void substract(int a, int b){
        result = a - b;
        System.out.println("빼기 결과:"+result);
    }

    public void multiply(int a, int b){
        result = a * b;
        System.out.println("곱하기 결과:"+result);
    }

    public void divide(int a, int b){
        if(b == 0){
            System.out.println("0으로 나눌 수 없습니다.");
            return;
        }
        result = a / b;
        System.out.println("나누기 결과:"+result);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.add(10, 20);
        calc.substract(30, 10);
        calc.multiply(40, 2);
        calc.divide(50, 2);
    }
}

