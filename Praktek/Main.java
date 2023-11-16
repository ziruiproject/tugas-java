import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double[] arr = generateRandomArray(10);

        double min = arr[9];
        for (double value : arr) {
            if (value < min) {
                min = value;
            }
        }

        double max = arr[9];
        for (double value : arr) {
            if (value > max) {
                max = value;
            }
        }

        System.out.println(min);
        System.out.println(max);
        System.out.println(Arrays.toString(arr));
    }

    private static double[] generateRandomArray(int size) {
        double[] array = new double[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            double randomValue = random.nextDouble() * 100;
            double roundedValue = Math.round(randomValue * 100.0) / 100.0;
            array[i] = roundedValue;
        }

        return array;
    }
}
