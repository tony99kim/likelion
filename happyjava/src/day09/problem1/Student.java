package day09.problem1;

public class Student {
    public String name;
    public int studentId;
    public int age;
    public double gpa;

    // 모든 정보를 받는 생성자
    public Student(String name, int studentId, int age, double gpa) {
        this.name = name;
        this.studentId = studentId;
        this.age = age;
        this.gpa = gpa;
    }

    // 이름과 학번만 받는 생성자
    // 나이는 18, GPA는 0.0으로 초기화
    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
        this.age = 18;
        this.gpa = 0.0;
    }

    // 나이 수정 메서드
    public void updateAge(int newAge) {
        if (newAge >= 15 && newAge <= 100) {
            this.age = newAge;
        } else {
            System.out.println("경고: 나이는 15~100 사이여야 합니다. 기존 값을 유지합니다.");
        }
    }

    // GPA 수정 메서드
    public void updateGpa(double newGpa) {
        if (newGpa >= 0.0 && newGpa <= 4.0) {
            this.gpa = newGpa;
        } else {
            System.out.println("경고: GPA는 0.0~4.0 사이여야 합니다. 기존 값을 유지합니다.");
        }
    }

    // 학생 정보 출력
    public void displayInfo() {
        System.out.println("이름: " + name);
        System.out.println("학번: " + studentId);
        System.out.println("나이: " + age);
        System.out.println("GPA: " + gpa);
        System.out.println();
    }

    // 우수학생 여부
    public boolean isExcellent() {
        return gpa >= 3.5;
    }
}
