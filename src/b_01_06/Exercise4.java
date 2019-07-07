package b_01_06;
import java.lang.Math;
import java.util.Scanner;
public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert a number:");
        int a = scanner.nextInt();
        PalindromNumber(a);
    }

    public static void PalindromNumber(int a){
        int b = a;
        int x = 0;
        int y = 0;
        int t = String.valueOf(a).length() - 1;

        while (a > 0) {
            x = a % 10;
            y = y + x * (int) Math.pow(10, t--);
            a = a / 10;
        }

        if (y == b) {
            System.out.println("The number is palindrom");
        } else {
            System.out.println("The number is not palindrom");
        }
    }

}

