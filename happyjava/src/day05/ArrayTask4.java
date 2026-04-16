package day05;

import java.util.Arrays;

public class ArrayTask4 {
    public static void main(String[] args) {
        int[][] gugudan = new int[8][9];

        for(int i=0;i<gugudan.length;i++){
            for(int j=0;j<gugudan[i].length;j++){
                gugudan[i][j] = (i+2)*(j+1);
            }
        }
        for(int i= 0; i<gugudan.length; i++){
            System.out.println((i+2)+"단:");
            for(int j=0;j<gugudan[i].length;j++){
                System.out.printf("%d * %d = %2d ",(i+2),(j+1),gugudan[i][j]);
            }
            System.out.println();
        }
    }
}
