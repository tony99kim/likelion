package day06;

public class Car {
    String color;
    public Car(){
        color = "빨강";
        System.out.println("car 생성자 호출");
    }

    public Car(String color){
        this.color = color;
    }

    public void 색깔바꾸다(String color){
        this.color = color;
    }
}
