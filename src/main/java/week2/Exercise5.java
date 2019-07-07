package week2;
import java.util.Scanner;
public class Exercise5 {
    public static int Prim() {
     Scanner sc= new Scanner(System.in);
        int a = sc.nextInt();
        int d = sc.nextInt();
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
return x;
    }

    public static void main(String[] args) {
        System.out.println(Prim());

    }
}