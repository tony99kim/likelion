package day04;

import java.util.Scanner;

public class ScannerExam1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
        int sum = 0;
        double average =0;

        for(int i = 0; i < 5; i++){
            arr[i] = sc.nextInt();
        }

        for(int j = 0; j < 5; j++){
            sum = sum+arr[j];
        }

        average = (double)sum/5;

        System.out.println("총합"+sum);
        System.out.println("평균"+average);
    }
}
