package lambdaexam;

import java.util.*;

class Student{
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return name;
    }
    public int getScore(){
        return score;
    }

}

public class StudentPractice {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("김철수", 85),
                new Student("이영희", 92),
                new Student("박민수", 78),
                new Student("정수진", 88),
                new Student("최영수", 95)
        );

        // TODO: 1. 80점 이상 학생 이름 출력
        // students.stream()...
        students.stream().filter(stu -> stu.getScore() >= 80).map(stu -> stu.getName()).forEach(System.out::println);

        // TODO: 2. 평균 점수 계산
        // double average = ...
        double average = students.stream().mapToInt(stu -> stu.getScore()).average().orElse(0.0);
        System.out.println("평균점수: " + average);

        // TODO: 3. 최고 점수 학생 찾기
        // Optional<Student> topStudent = ...
        Optional<Student> topStudent = students.stream().max(Comparator.comparingInt(stu -> stu.getScore()));
        topStudent.ifPresent(stu -> System.out.println("최고점수 학생: "+stu.getName()+" "+stu.getScore()+"점"));
    }

}
