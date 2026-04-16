package day06;

public class DiceGame {

    int eye;

    public void roll(){
        eye = ((int)(Math.random()*6)+1);
    }


    public static void countEye(Dice dice, int rollTimes, int eye) {
        int count = 0;
        for(int i=0;i<rollTimes;i++){
            dice.roll();
            if(dice.eye == eye){
                count++;
            }
        }
        System.out.printf("Eye %d appeared %d times out of %d rolls", eye, count, rollTimes);
    }

    public static void main(String[] args) {
        Dice dice = new Dice();
        countEye(dice, 100, 6);
    }
}
