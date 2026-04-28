package ioexam;

class SumThread extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
public class JoinExam {
    public static void main(String[] args) {
        System.out.println("main 시작");

         SumThread t1 = new SumThread();
         t1.start();

         System.out.println("sumThread가 계산 하는 동안에 main 할일 실행!!");
         try{
             t1.join();
         } catch (InterruptedException e) {
             System.out.println(e.getMessage());
         }
         System.out.print("sumThread가 계산한 결과 값을 이용해서 뭔가 일을 한다...");
    }
}
