package streamexam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).toList();

        System.out.println("짝수"+ evenNumbers);

        List<Integer> filtered = numbers.stream().filter(n -> n>3).filter(n -> n<8).collect(Collectors.toList());

        System.out.println("3보다 크고 8보다 작은 수"+ filtered);
    }
}
