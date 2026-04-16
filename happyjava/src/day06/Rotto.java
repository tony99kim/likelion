package day06;

public class Rotto {
    int ballNum;

    public void draw(){
        ballNum = ((int)(Math.random()*45)+1);
    }

    public static void rottoDraw(Rotto rotto, int ballDraw) {
        int[] ballresult = new int[ballDraw];

        for (int i = 0; i < ballDraw; i++) {
            rotto.draw();
            ballresult[i] = rotto.ballNum;
        }

        System.out.print("로또 결과: ");
        for(int i = 0; i < ballDraw; i++){
            System.out.print(ballresult[i] + " ");
        }
    }
    public static void main(String[] args) {
        Rotto rotto = new Rotto();
        rottoDraw(rotto, 6);
    }
}

