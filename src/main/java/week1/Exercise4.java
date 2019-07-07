package week1;

import java.util.Scanner;
public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert a number:");
        int a = scanner.nextInt(); // incearca sa dai nume sugestive variabilelor
        palindromNumberVariantaPropusaDeMine(a);
    }

    //vezi si varianta asta
    public static void palindromNumberVariantaPropusaDeMine(int number) {
        int temp = number;
        int reverse = 0;

        while (number > 0) {
            int digit = number % 10;
            reverse = (reverse * 10) + digit;
            number /= 10;
        }

        if (temp == reverse) {
            System.out.println("Numarul este palindrom");
        } else {
            System.out.println("Numarul nu este palindrom");
        }

    }

    public static void palindromNumber(int a) {
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



