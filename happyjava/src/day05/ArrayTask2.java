package day05;

import java.util.Arrays;

public class ArrayTask2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        int max = arr[0];
        int min = arr[0];

        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println("배열: "+ Arrays.toString(arr));
        System.out.println("Max: "+max);
        System.out.println("Min: "+min);
    }
}
