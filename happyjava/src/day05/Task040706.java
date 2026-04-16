package day05;

public class Task040706 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int firstsum = 0;
        int secondsum = 0;

        for (int i = 0; i < matrix.length; i++) {
            firstsum += matrix[i][i];
            secondsum += matrix[i][matrix.length -1 -i];
        }

        System.out.printf("주 대각선 합 : %d",firstsum);
        System.out.println();
        System.out.printf("부 대각선 합 : %d",secondsum);
    }
}
