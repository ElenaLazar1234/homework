package Coding_Assignment;

public class Triangle implements Shape{

    double lenght2;
    double lenght1;
    double lenght3;

    public Triangle(double newLenght1,double newLenght2,double newLenght3){
        lenght1 = newLenght1;
        lenght2 = newLenght2;
        lenght3 = newLenght3;
    }

    @Override
    public double Area() {
        return  Math.sqrt((Perimeter()-lenght1)*(Perimeter()-lenght2)*(Perimeter()-lenght2));
    }

    @Override
    public double Perimeter() {
        double p=(lenght1+lenght2+lenght3)/2;
        return p;
    }
}
