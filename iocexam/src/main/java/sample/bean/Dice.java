package sample.bean;

public class Dice {
    private int face = 6;
    public Dice() {
        System.out.println("Dice() 생성");
    }

    public Dice(int face) {
        this.face = face;
        System.out.println("Dice(int face) 생성");
    }

    public int getNumber() {
        return (int)(Math.random()*face+1);
    }

    public int setFace(int face) {
        return this.face = face;
    }
}
