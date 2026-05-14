package streamexam.task2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class Student{
    private String name;
    private Map<String,Integer> scores;

    public Student(String name, Map<String,Integer> scores) {
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    public double getAverage() {
        return scores.values().stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public String getGrade(){
        double averageScore =getAverage();
        if(averageScore >= 90) return "A";
        else if(averageScore >= 80) return "B";
        else if(averageScore >= 70) return "C";
        else return "D";
    }
}
public class GradeProcessor {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("김태엽",Map.of("수학",100,"영어",100,"과학",100,"국어",100)),
                new Student("김태영",Map.of("수학",90,"영어",90,"과학",90,"국어",90)),
                new Student("김태훈",Map.of("수학",10,"영어",20,"과학",10,"국어",10)),
                new Student("김태준",Map.of("수학",70,"영어",70,"과학",70,"국어",70))
        );

//        평균 점수가 80점 이상인 학생 찾기
        System.out.println("======평균 점수가 80점 이상인 학생======");
        students.stream().filter(stu -> stu.getAverage() >= 80).forEach(stu -> System.out.println(stu.getName()+", 평균 점수: "+stu.getAverage()));
//        과목별 최고 점수 구하기
        System.out.println("======과목별 최고 점수 구하기======");

//        전체 학생의 평균 점수 계산
        System.out.println("======전체 학생의 평균 점수 계산======");

//        학생을 등급별로 분류 (A: 90이상, B: 80-89, C: 70-79, D: 70미만)
        System.out.println("======학생을 등급별로 분류======");


    }

}
