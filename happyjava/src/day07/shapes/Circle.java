package day06.shapes;

public class Circle {
    private double radius;
    private static final double PI = 3.14159;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * PI * radius;
    }

    public void displayInfo() {
        System.out.println("원의 반지름: " + radius);
        System.out.println("원의 면적: " + getArea());
        System.out.println("원의 둘레: " + getPerimeter());
    }
}

