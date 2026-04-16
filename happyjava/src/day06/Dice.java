package day06;

public class Dice {

    int eye;

    public void roll(){
        eye = ((int)(Math.random()*6)+1);
    }

    public static void main(String[] args) {
        Dice dice = new Dice();

        int count = 0;

        for(int i=0;i<100;i++){
            dice.roll();
                if(dice.eye == 3){
                    count++;
                }
        }
        System.out.println(count);
    }
}


