package Coding_Assignment;

public class Rectangle implements Shape {

    public double length;
    public double width;

    public Rectangle(double newLength, double newWidth) {

        length = newLength;
        width = newWidth;
    }

    @Override
    public double Area() {
        return length * width;
    }

    @Override
    public double Perimeter() {
        return 2*(length + width);
    }
}