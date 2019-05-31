package a_25_05;
public class Exercise5 {

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
}


