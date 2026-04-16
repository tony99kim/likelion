package day06.task1;

public class Student {
    private String name;
    private int age;
    private int grade;

    public Student(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public void displayInfo() {
        System.out.println("학생 이름: " + name);
        System.out.println("학생 나이: " + age);
        System.out.println("학년 : " + grade+"학년");
    }

    public static void main(String[] args) {
        Student student = new Student("김태엽", 28, 4);
        student.displayInfo();
    }
}
