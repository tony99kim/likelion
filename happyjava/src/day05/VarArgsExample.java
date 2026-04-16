package day05;

public class VarArgsExample {
    public static int sum(int... numbers){
        int total = 0;
        for(int num : numbers){
            total += num;
        }
        return total;
    }

    public static void printInfo(String name, int... scores){
        System.out.print(name+"의 점수: ");
        for(int score : scores){
            System.out.print(score+" ");
        }
        System.out.println("(총 "+ scores.length+"과목");
    }

    public static void main(String[] args) {
        System.out.println("sum(1, 2) = " + sum(1, 2));
        System.out.println("sum(1, 2, 3) = " + sum(1, 2, 3));
        System.out.println("sum(1, 2, 3, 4, 5) = " + sum(1, 2, 3, 4, 5));
        System.out.println("sum() = " + sum());

        int[] arr = {10, 20, 30};
        System.out.println("sum(arr) = " + sum(arr));

        System.out.println();
        printInfo("김철수", 90, 85, 88);
        printInfo("이영희", 95, 92);
    }
}
