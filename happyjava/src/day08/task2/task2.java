package day08.task2;

public class task2 {
    public static void main(String[] args) {
//        Shape[] shapes = new Shape[2];
//        shapes[0] = new Circle(2);
//        shapes[1] = new Rectangle(3,4);

        Shape[] shapes2 = {new Circle(2), new Rectangle(3, 4)};

        for (Shape shape : shapes2) {
            if (shape instanceof Rectangle) {
                System.out.println("Rectangle - Area: " + shape.getArea() + ", Perimeter: " + shape.getPerimeter());
            } else {
                System.out.println("Circle - Area: " + shape.getArea() + ", Perimeter: " + shape.getPerimeter());
            }
        }
    }
}


abstract class Shape{

    abstract double getArea();

    abstract double getPerimeter();
}


class Circle extends Shape{
    double radius;

    Circle(double radius){
        this.radius = radius;
    }

    @Override
    double getArea(){
        return Math.PI * radius * radius;
    }

    @Override
    double getPerimeter(){
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }


    @Override
    double getArea() {
        return width * height;
    }

    @Override
    double getPerimeter() {
        return 2 * (width + height);
    }

}

