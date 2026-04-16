package day04;

public class StringExam2 {
    public static void main(String[] args) {
        int repeat = Integer.parseInt(args[0]);
        String hello = " ";
        for (int i = 0; i < repeat; i++) {
            hello += "hello\t";
        }
        System.out.println(hello);
    }
}
