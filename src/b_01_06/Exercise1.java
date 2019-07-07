package b_01_06;
import java.util.Scanner;

public class Exercise1 {


    public static int  Sum(){

        Scanner x = new Scanner(System.in);

        int n = x.nextInt();
        int sum = 0;

        for (int a = 1; a <= n;a++) {
            sum = a + sum;
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(Sum());
    }
}

