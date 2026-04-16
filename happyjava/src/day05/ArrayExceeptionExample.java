package day05;

public class ArrayExceeptionExample {
    public static void main(String[] args) {
        int[] arr = new int[3];

        try{
            arr[0] = 20;
            arr[3] = 30;
        }catch(Exception e){
            System.out.println("예외가 발생할때만 실행 ");
        }


        System.out.println("다음코드!!");
    }
}
