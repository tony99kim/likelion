package streamexam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TraversalExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // forEach - 최종 연산
        System.out.println("=== forEach 예시 ===");
        numbers.stream()
                .forEach(n -> System.out.println("Number: " + n));

        // peek - 중간 연산 (디버깅용)
        System.out.println("\n=== peek 예시 ===");
        List<Integer> doubled = numbers.stream()
                .peek(n -> System.out.println("원본: " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("두 배: " + n))
                .collect(Collectors.toList());

        System.out.println("최종 결과: " + doubled);
    }
}
