package day08;

public class Task1 {
    public static void main(String[] args) {
        Animal dog = new Dog("뽀삐");
        Animal cat = new Cat("나비");

        dog.makeSound();
        dog.eat();

        cat.makeSound();
        cat.eat();
    }
}

abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public void eat() {
        System.out.println("동물이 먹이를 먹습니다.");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("야옹");
    }
}