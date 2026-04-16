package day06;

public class Caruser {
    public static void main(String[] args) {
        Car car = new Car();
        car.색깔바꾸다("흰색");
        System.out.println(car.color);



        Car car2 = new Car("초록");
        System.out.println(car2.color);
    }

}
