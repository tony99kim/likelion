package day07;

class Pen {
    String 색깔;
    String 제조사;
    int 잉크량;

    public Pen(){
        System.out.println("Pen 생성자 실행");
        색깔 = "검정";
        제조사 = "모나미";
        잉크량 = 100;
    }

    public void 쓰다(){
        this.색깔 = 색깔;

    }
    public void 머리에꽂다(){

    }
}

public class Exam1 {
    public static void main(String[] args) {
        int i = 10;
        char c ='c';

        Pen pen = new Pen();
        System.out.println(pen.잉크량);
        System.out.println(pen.제조사);
        System.out.println(pen.잉크량);

    }
}
