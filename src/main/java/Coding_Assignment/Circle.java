package Coding_Assignment;
import java.lang.Math;

public class Circle implements Shape {
        double radius;
    public Circle(double newRadius){
        radius = newRadius ;
}

    @Override
    public double Area() {
        return Math.pow(radius,2) * Math.PI;
    }

    @Override
    public double Perimeter() {
        return 2*Math.PI*radius;
    }
}
