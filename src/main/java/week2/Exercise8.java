package week2;
import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {

        Scanner next = new Scanner(System.in);
        System.out.println("Please insert a number");
        int n = next.nextInt();

        Factorial(n);
    }

    public static void Factorial(int n) {
        int factorial = 1;
        int x = 1;
        while (x <= n) {
            factorial *= x;
            x++;
        }


        System.out.println("n!= "+ factorial);
    }
}
