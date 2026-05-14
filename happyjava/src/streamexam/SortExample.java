package streamexam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Banana", "Apple", "Cherry", "Date");

        // 자연 순서 정렬 (오름차순)
        List<String> sortedAsc = fruits.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("오름차순: " + sortedAsc);
        // [Apple, Banana, Cherry, Date]

        // 역순 정렬 (내림차순)
        List<String> sortedDesc = fruits.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("내림차순: " + sortedDesc);
        // [Date, Cherry, Banana, Apple]

        // 길이 기준 정렬
        List<String> sortedByLength = fruits.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        System.out.println("길이순: " + sortedByLength);
        // [Date, Apple, Banana, Cherry]
    }
}
