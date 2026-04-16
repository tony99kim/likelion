package day10;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class Calendar {

    public static void printCalendar(int year, int month) {
        YearMonth ym = YearMonth.of(year, month);
        int lastDay = ym.lengthOfMonth();

        LocalDate firstDate = LocalDate.of(year, month, 1);
        DayOfWeek firstDayOfWeek = firstDate.getDayOfWeek(); // MONDAY ~ SUNDAY
        int startBlank = firstDayOfWeek.getValue() % 7; // 일요일 시작 기준으로 맞춤

        System.out.println("[" + year + "년 " + month + "월]");
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        for (int i = 0; i < startBlank; i++) {
            System.out.print("\t");
        }

        for (int day = 1; day <= lastDay; day++) {
            System.out.print(day + "\t");

            if ((startBlank + day) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();

        printCalendar(year, month);
    }
}