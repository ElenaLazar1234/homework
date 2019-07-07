package week1;
public class Exercise2_v2 {

    public static void main(String[] args) {
        int numbers[] = {15, 25, 4, 2, 3};
        int min = numbers[0];

        for (int x : numbers) {
            if(x <min){
                min=x;
            }
        }
        System.out.println(min);
    }

}