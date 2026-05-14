package lambdaexam;

@FunctionalInterface
interface Greeting {
   void sayHello();
}

@FunctionalInterface
interface StringProcessor {
    String process(String str);
}

@FunctionalInterface
interface Calculator {
    double calculate(double a, double b);
}

public class LambdaExamples {
    public static void main(String[] args) {
        Greeting greeting = () -> System.out.println("안녕하세요");
        greeting.sayHello();

        StringProcessor upperCase = str -> str.toUpperCase();
        System.out.println(upperCase.process("hello"));

        Calculator multiply = (a, b) -> a * b;
        System.out.println(multiply.calculate(5.0, 3.0)); // 15.0

        // 복잡한 로직을 가진 람다식
        Calculator complexCalc = (a, b) -> {
            double result = a + b;
            System.out.println("계산 중: " + a + " + " + b);
            return result;
        };
        System.out.println(complexCalc.calculate(10.0, 20.0));
    }
}
