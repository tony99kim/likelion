package day06.task4;

public class Animal {
    private String name;
    private String type;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public static void main(String[] args) {
        Animal a1 = new Animal("뽀삐", "개");
        Animal a2 = new Animal("나비", "고양이");
        Animal a3 = new Animal("찡찡이", "햄스터");

        System.out.printf("이름: %s, 종류: %s%n", a1.name, a1.type);
        System.out.printf("이름: %s, 종류: %s%n", a2.name, a2.type);
        System.out.printf("이름: %s, 종류: %s%n", a3.name, a3.type);
    }
}
