package day06.task2;

public class Tv {
    private boolean power;
    private int channel;

    public void togglePower(){
        power = !power;
        if(power) System.out.println("전원이 켜졌습니다");
        else System.out.println("전원이 꺼졌습니다.");
    }

    public void changeChannel(int newChannel){
        channel = newChannel;
        System.out.printf("채널을 %d번으로 변경했습니다 ",channel);
        System.out.println();
    }

    public static void main(String[] args) {
        Tv tv = new Tv();
        tv.togglePower();
        tv.changeChannel(10);
        tv.togglePower();
        tv.togglePower();

    }
}
