package week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.OptionalInt;
import java.lang.Object;

public class  StreamsExercises {
    public static List<Transaction> FindAllTransactions(int year, List<Transaction> transactions) {
        Stream<Transaction> transactionsFromYear = transactions.stream();

        return transactionsFromYear
                .filter(transaction -> transaction.getYear() == year)
                .sorted(Comparator.comparing(s -> s.getValue()))
                .collect(Collectors.toList());
    }

    public static List<String> FindUniqueCities(List<Trader> traders) {


        return traders.stream()
                .map(s -> s.getCity())
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Trader> TradersFromCity(String city, List<Trader> traders) {
        return traders.stream()
                .filter(s -> s.getCity().equals(city))
                .sorted(Comparator.comparing(trader -> trader.getName()))
                .collect(Collectors.toList());
    }

    public static void TradersNames(List<Trader> traders) {

        traders.stream()
                .sorted(Comparator.comparing(t -> t.getName()))
                .map(x -> x.getName())
                .forEach(x -> System.out.print(" " + x + " "));
    }

    public static boolean AnyTrader(List<Trader> traders, String city) {
        return traders.stream()
                .anyMatch(any -> any.getCity().equals(city));
    }

    public static List<Integer> TransactionsValues(List<Transaction> transactions, String city) {
        return transactions.stream()
                .filter(m -> m.getTrader().getCity().equals(city))
                .map(n -> n.getValue())
                .collect(Collectors.toList());
    }

    public static int HighestValue(List<Transaction> transactions) {
        return transactions.stream()
                .max(Comparator.comparing(Transaction::getValue))
                .map(s -> s.getValue()).get();
    }

    public static int SmallestValue(List<Transaction> transactions) {
        return transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .map(s -> s.getValue()).get();

    }


    public static void main(String[] args) {

        Trader trader1 = new Trader("Ana", "Milan");
        Trader trader2 = new Trader("Paul", "Cambridge");
        Trader trader3 = new Trader("Elena", "Cambridge");
        Trader trader4 = new Trader("Stan", "Barcelona");

        List<Trader> traders = new ArrayList<>();
        traders.add(trader1);
        traders.add(trader2);
        traders.add(trader3);
        traders.add(trader4);

        List<Transaction> transactions = Arrays.asList(
                new Transaction(trader1, 2011, 1500),
                new Transaction(trader2, 2010, 1400),
                new Transaction(trader3, 2009, 500),
                new Transaction(trader4, 2011, 600));
        System.out.println("1." + " " + FindAllTransactions(2011, transactions));
        System.out.println("2." + " " + FindUniqueCities(traders));
        System.out.println("3." + " " + TradersFromCity("Cambridge", traders));
        System.out.print("4." + " ");
        TradersNames(traders);
        System.out.println();
        System.out.println("5." + " " + AnyTrader(traders, "Milan"));
        System.out.println("6." + " " + TransactionsValues(transactions, "Cambridge"));
        System.out.println("7." + " " + HighestValue(transactions));
        System.out.println("8." + " " + SmallestValue(transactions));
        FibonacciSequence fibonacci = new FibonacciSequence();
        fibonacci.FibonacciSequence(100);

    }
}