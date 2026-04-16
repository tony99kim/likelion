package day10;

import java.util.Scanner;

public class SystemIDExample {
    public static void main(String[] args) {

        System.out.println("일반 메세지");
        System.out.println("에러 메세지");

        Scanner scanner = new Scanner(System.in);
        System.out.println("입력: ");
        String name = scanner.nextLine();
        System.out.println("안녕하세요: " + name+"님!");
        scanner.close();
    }
}
