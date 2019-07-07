package b_01_06;
import java.util.Scanner;

public class Exercise6 {
    public static String Calculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti primul numar: ");
        int n1 = scanner.nextInt();
        System.out.println("Introduceti al doilea numar: ");
        int n2 = scanner.nextInt();
        System.out.println("Introduceti operatia dorita: ");
        String operation = scanner.next();

        if (operation.equals("+")) {
            return n1 + " + " + n2 + " = " + (n1 + n2);
        } else if (operation.equals("-")) {
           return  n1 + " - " + n2 + " = " + (n1 - n2);
        } else if (operation.equals("*")) {
           return n1 + " * " + n2 + " = " + (n1 * n2);
        } else if (operation.equals("/")) {
            return n1 + " / " + n2 + " = " + (n1 / n2);
        } else {
          return "bad operation!";
        }

    }

    public static void main(String[] args) {

        System.out.println(Calculator());
    }
}

