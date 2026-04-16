package day05;

import java.util.Arrays;

public class ArrayTask3 {
    public static void main(String[] args) {
        int[] original = {1,2,3,4,5,6,7,8,9,10};
        int[] reversed = new int[original.length];

        for(int i=0;i<original.length;i++){
            reversed[i] = original[original.length-1-i];
        }

        System.out.println(Arrays.toString(original));
        System.out.println(Arrays.toString(reversed));

    }
}
