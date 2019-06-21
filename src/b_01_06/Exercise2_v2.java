package b_01_06;
import java.util.Scanner;
import java.util.*;
public class Exercise2_v2 {


    public static int Smallest() {
int min=0;

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] mylist = new int[n];
        for (int i = 0; i < n; i++) {
            mylist[i] = sc.nextInt();

        }
        min = mylist[0];
            for (int x : mylist) {
                if (x < min) {
                    min = x;
                }

            }

            return min;

    }
    public static void main(String[] args) {

        System.out.println(Smallest());
    }
}
