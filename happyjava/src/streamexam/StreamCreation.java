package streamexam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String[] args) {
        // List에서 스트림 생성
        List<String> list = Arrays.asList("Java", "Python", "JavaScript");
        Stream<String> streamFromList = list.stream();

        // Set에서 스트림 생성
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Stream<Integer> streamFromSet = set.stream();

// 배열에서 스트림 생성
        String[] array = {"Spring", "Summer", "Fall", "Winter"};
        Stream<String> streamFromArray = Arrays.stream(array);

// 부분 배열에서 스트림 생성
        Stream<String> partialStream = Arrays.stream(array, 1, 3); // Summer, Fall

// Stream.iterate() - 무한 스트림 생성
        Stream<Integer> iterateStream = Stream.iterate(0, n -> n + 2)
                .limit(10); // 0, 2, 4, 6, 8...

// Stream.generate() - 무한 스트림 생성
        Stream<Double> randomStream = Stream.generate(Math::random)
                .limit(5);
    }
}
