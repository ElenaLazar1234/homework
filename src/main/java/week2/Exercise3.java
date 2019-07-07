package week2;

import java.util.Scanner;
public class Exercise3 {


    public static int  Digit(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int rest;
        int max=0;

        while (a>=1) {

            rest = a % 10;
            a = a / 10;

            if (rest >= max) {
                max = rest;

            }
        }
        return max;
    }

    public static void main (String[] args) {

        System.out.println(Digit());
    }
}

