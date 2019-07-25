package Coding_Assignment;
import java.lang.Math;
public class Square implements Shape{
    double length;
    public Square(double newLength){
         length = newLength;
    }

    @Override
    public double Area() {
        return Math.pow(length,2);
    }

    @Override
    public double Perimeter() {
        return 4*length;
    }
}
