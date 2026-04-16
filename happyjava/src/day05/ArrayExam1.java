package day05;

public class ArrayExam1 {
    public static void main(String[] args) {
        int[] arr = new int[10];

        for(int i=0;i<arr.length;i++){
            arr[i]=i;
        }

        System.out.println(arr[0]);
        System.out.println(arr[1]);

        int exChange = arr[0];
        arr[0]=arr[1];
        arr[1]=exChange;

        System.out.println(arr[0]);
        System.out.println(arr[1]);

        char[] charArr = {'a','b','c','d','e'};
        for(char c:charArr){
            System.out.println(c);
        }
    }
}
