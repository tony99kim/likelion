package day07;

public class Exam2 {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.i = 10;

        System.out.println(parent.i);

        Child child = new Child();
        child.i = 20;

        System.out.println(child.i);

    }
}
