package streamexam;


import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Exam01 {
    public static void main(String[] args) {
        int[] iarr = {1,2,3,4,5,6,7,8,9,10};

        for(int i=0; i<iarr.length; i++){
            if(iarr[i]%2==0){
                System.out.println(iarr[i]);
            }
        }

        System.out.println("=".repeat(50));

        for(int value : iarr){
            if(value%2==0){
                System.out.println(value);
            }
        }

        System.out.println("=".repeat(50));

        IntStream stream = Arrays.stream(iarr);
//        stream.filter(new IntPredicate() {
//            @Override
//            public boolean test(int value) {
//                    return value % 2 == 0;
//            }
//        });

        IntStream intStream = stream.filter(x -> x % 2 == 0);

        //intStream.forEach(i -> System.out.println(i));

        intStream.forEach(System.out::println);

        System.out.println("=".repeat(50));

        //메서드 체이닝
        Arrays.stream(iarr)
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);
    }
}
