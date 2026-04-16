package day05;

import java.util.Arrays;

public class ArrayUtilExample {
    public static void main(String[] args) {
    int[] numbers = {5,2,8,1,9,3};

    System.out.println("원본 배열: " + Arrays.toString(numbers));

    int[] sorted = Arrays.copyOf(numbers, numbers.length);
    Arrays.sort(sorted);
    System.out.println("정렬된 배열: " +Arrays.toString(sorted));

    int index = Arrays.binarySearch(sorted, 5);
    System.out.println("5의 위치: "+index);

    int[] arr1 = {1,2,3};
    int[] arr2 = {1,2,3};
    int[] arr3 = {1,2,4};
    System.out.println("arr1 == arr2: " + Arrays.equals(arr1, arr2));
    System.out.println("arr1 == arr3: " + Arrays.equals(arr2, arr3));

    int[] filled = new int[5];
    Arrays.fill(filled, 7);
    System.out.println("채워진 배열:"+Arrays.toString(filled));

    }
}
