package day05;

public class Task040703 {
    public static void main(String[] args) {

        int[] scores = {70, 85, 90, 45, 100};

        int sum = 0;

        for(int i = 0; i < scores.length; i++){
            sum += scores[i];
        }

        double avg = (double)sum/scores.length;

        System.out.println("Sum: " + sum);
        System.out.printf("Avg: %.2f\n", avg);
    }
}
