package b_01_06;
import java.util.Scanner;
import java.util.*;
public class Exercise2 {


    public static int Smallest() {
        int min=0;
        ArrayList mylist = new ArrayList();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            mylist.add(sc.nextInt());
        }
            Iterator it = mylist.iterator();
            while (it.hasNext()) {
                Object element = it.next();
                min = (int) mylist.get(0);
                for (int i = 0; i < n; i++) {
                if((int) mylist.get(i)< (int)mylist.get(0)){
                    min=(int)mylist.get(i);
                }

            }
        }
        return min;
    }

    public static void main(String[] args) {

        System.out.println(Smallest());
    }

}