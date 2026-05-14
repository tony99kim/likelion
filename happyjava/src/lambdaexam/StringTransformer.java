package lambdaexam;

import java.util.function.*;

public class StringTransformer {
    public static void main(String[] args) {
        // TODO: 문자열 변환 람다식 구현
        // Function<String, String> toUpperCase = ???
        // Function<String, String> toLowerCase = ???
        // Function<String, String> reverse = ???
        Function<String, String> toUpperCase = s -> s.toUpperCase();
        Function<String, String> toLowerCase = s -> s.toLowerCase();
        Function<String, String> reverse = s -> new StringBuilder(s).reverse().toString();

        String str = "Tae yeop";
        System.out.println("원본: "+str);
        System.out.println("대문자: "+transform(str, toUpperCase));
        System.out.println("소문자"+ transform(str, toLowerCase));
        System.out.println("역순"+ transform(str, reverse));

        // TODO: transform 메서드로 테스트
        // System.out.println(transform("Hello", toUpperCase));
         System.out.println(transform("Hello", toUpperCase));
    }

    public static String transform(String str, Function<String, String> transformer) {
        // TODO: 구현하세요
        return null;
    }
}