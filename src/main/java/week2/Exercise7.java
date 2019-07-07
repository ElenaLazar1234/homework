package week2;
import java.util.Scanner;

public class Exercise7 {
    public static void MyCalculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti primul numar: ");
        int n1 = scanner.nextInt();
        System.out.println("Introduceti al doilea numar: ");
        int n2 = scanner.nextInt();
        System.out.println("Introduceti operatia dorita: ");

        String operation = scanner.next();
        int result = 0;
        while (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {

            switch (operation) {
                case "+": //in case-uri se pot folosi numere intregi si stringuri si booleeni
                    result = n1 + n2;
                    System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
                    break;
                case "-":
                    result = n1 - n2;
                    System.out.println(n1 + " - " + n2 + " = " + (n1 - n2));
                    break;
                case "*":
                    result = n1 * n2;
                    System.out.print(n1 + " * " + n2 + " = " + (n1 * n2));
                    break;
                case "/":
                    result = n1 / n2;
                    System.out.println(n1 + " / " + n2 + " = " + (n1 / n2));

                default:
                    System.out.println("Bad operation!");

            }

            System.out.println("Introduceti operatia dorita: ");
            operation = scanner.next();
            System.out.println("Introduceti alt numar");
            n1 = result;
            n2 = scanner.nextInt();

        }
    }


    public static void main(String[] args) {
        MyCalculator();
    }
}


