package day05;

import java.util.Arrays;

public class MultiArrayExample {
    public static void main(String[] args) {
        int[][] iarr;
        //iarr = new int[5];
        iarr = new int[5][3];

        int[][][] iarr2 = new int[2][3][2];
        iarr2[0][1][0] = 10;

        int[][][] iarr3 = new int [3][][];

        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        for(int i =0; i<matrix.length; i++){
            for(int j =0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }

        int[][] jagged = new int[3][];
        jagged[0] = new int[]{1,2};
        jagged[1] = new int[]{3,4,5};
        jagged[2] = new int[]{6,7,8,9};

        for(int[] row : jagged){
            System.out.println(Arrays.toString(row));
        }
    }
}
