package week7;
import java.util.List;
import java.util.stream.Stream;

public class FibonacciSequence {

    public static void FibonacciSequence(int sequence) {

        Integer[] mySequence = new Integer[sequence];
        mySequence[0] = 0;
        mySequence[1] = 1;
        mySequence[2] = 1;
        Stream<Integer> intMySequence  = Stream.of(mySequence);


         intMySequence.filter(x-> x <= 98)
                .forEach(l-> mySequence[l+2]=mySequence[l+1]+ mySequence[l]);
        intMySequence.forEach(System.out::println);

}
}
