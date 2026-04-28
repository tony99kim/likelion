package threadexam;

class MyThread extends Thread{
    String name;

    public MyThread(){
        this.name = name;
    }

    @Override
    public void run(){
     System.out.println(name + " 스레드 스따또!");
        for(int i = 0; i < 10; i++){
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
            System.out.println(name + "안녕");
        }
        System.out.println(name+"스레드 종료");
    }
}
public class ThreadExam01 {
    public static void main(String[] args) {
        System.out.println("메인 스레드 시작");

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.setName("Thread-A");
        thread2.setName("Thread-B");

        thread1.start(); // 스레드 시작
        thread2.start();

        System.out.println("메인 스레드 종료");
    }

}
