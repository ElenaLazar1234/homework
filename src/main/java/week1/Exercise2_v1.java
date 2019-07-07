package week1;
public class Exercise2_v1 {

    public static void main(String[] args) {
        int numbers[] = {25, 30, 7, 2, 15};
        int min = numbers[0];

        for (int x = 1; x <= 4; x++) {
            if (numbers[x] < min) {
                min = numbers[x];
            }
        }
        System.out.println(min);
    }
}
