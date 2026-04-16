package day07.shapes;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public void displayInfo() {
        System.out.println("사각형 크기: " + width + " x " + height);
        System.out.println("사각형 면적: " + getArea());
        System.out.println("사각형 둘레: " + getPerimeter());
    }
}
