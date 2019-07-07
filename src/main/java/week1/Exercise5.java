package week1;

import java.util.Scanner;

public class Exercise5 {

    /*
    public static void main(String[] args) {
        int a = 50;
        int d = 2;
        int x;
        int prim;
        for (x = 2; x < a; x++) {
            prim = 1;
            while (d <= (x / 2)) {
                if (x % d == 0) {
                    prim = 0;
                }
                d++;
            }
            if (prim == 1) {
                System.out.println(x + " " + "este nr prim");
            } else {
                System.out.println(x + " " + "nu este nr prim");
            }
        }
    }
    */

    //Ce zici de varianta asta?
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        for (int i = n; i >= 2; i--) {
            if (isPrime(i)) //verifici daca e prim
                System.out.println(i);
        }
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j < i / 2; j++) {
            if (i % j == 0)
                return false;
        }
        return true;
    }
    //PS: a ta nu functiona corect
}


