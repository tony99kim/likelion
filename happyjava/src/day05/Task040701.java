package day05;

public class Task0407 {
    public static void main(String[] args) {

        int[] numbers = {3,6,9,12,15};
        int[] reverse = new int[numbers.length];

        for(int i=0;i<numbers.length;i++){
            reverse[i] = numbers[numbers.length-1-i];
        }

        for(int i=0;i<numbers.length;i++){
            System.out.println(reverse[i]);
        }
    }
}
