package day02;

public class VariableTest {
    public static void main(String[] args) {
        //변수선언방법
        //접근제한자 타입 변수명;
        //접근제한자 타입 변수명 = 초기화;
        String name = "Taeyeop";
        String message = "안녕하다 임마";

        String greeting = name + "님, " + message;
        System.out.println(greeting);

        int age = 20;
        String info = "나이: " + age + "세" ;
        System.out.println(info);
    }
}
