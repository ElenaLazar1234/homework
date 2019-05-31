package a_25_05;
public class Exercise3 {
    public static void main (String[] args){
            int a=1988;
            int rest;
            int max=0;

        while (a>=1) {

            rest = a % 10;
            a = a / 10;

            if (rest >= max) {
                max = rest;

            }
        }
        System.out.println(max);
    }
}

