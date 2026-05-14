package lambdaexam;

import java.util.*;
import java.util.function.*;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "charlie", "david");

        // 1. 정적 메소드 참조
        names.forEach(System.out::println); // System.out.println(name) 와 동일

        // 2. 인스턴스 메소드 참조
        names.stream()
                .map(String::toUpperCase) // str -> str.toUpperCase() 와 동일
                .forEach(System.out::println);

        // 3. 생성자 참조
        Supplier<List<String>> listSupplier = ArrayList::new; // () -> new ArrayList<>() 와 동일
        List<String> newList = listSupplier.get();

        // 4. 특정 객체의 메소드 참조
        String prefix = "Name: ";
        Function<String, String> addPrefix = prefix::concat; // str -> prefix.concat(str) 와 동일

        names.stream()
                .map(addPrefix)
                .forEach(System.out::println);
    }
}
