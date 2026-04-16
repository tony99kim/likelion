package day05;

import java.util.*;

public class ScoreTableExample {
    public static void main(String[] args) {
        String[] students = {"김태엽","정의찬","이상민"};
        String[] subjects = {"국어","영어","수학","과학"};
        int[][] scores = {
                {90,85,88,92},
                {85,90,95,88},
                {78,82,85,90}
        };

        System.out.println("=== 성적표 ===");
        System.out.print("이름\t");
        for(String subject : subjects){
            System.out.print(subject+"\t");
        }
        System.out.println("총점\t 평균");
        System.out.println("-".repeat(50));

        for(int i =0; i<students.length; i++){
            System.out.print(students[i]+"\t");
            int sum =0;
            for(int j=0; j<scores.length; j++){
                System.out.print(scores[j][i]+"\t");
                sum+=scores[j][i];
            }
            double avg = sum/(double)scores[i].length;
            System.out.printf("%d\t%.1f\n",sum,avg);
        }
    }
}
