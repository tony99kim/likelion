package day06;

public class Smartphone {
    private String brand;
    private String model;
    private int batteryLevel;

    public Smartphone(String brand, String model, int batteryLevel) {
        this.brand = brand;
        this.model = model;
        this.batteryLevel = batteryLevel;
    }

    public void checckBattery() {
        System.out.println("현재 배터리 수준: " + batteryLevel + "%");
    }

    public void charge(){
        batteryLevel += 10;
        System.out.println("충전 중.. 배터리가 10% 증가했습니다.");
    }

    public static void main(String[] args) {
        Smartphone sp = new Smartphone("Apple", "iPhone 13", 50);
        sp.checckBattery();
        sp.charge();
        sp.charge();
        sp.checckBattery();
    }

}
