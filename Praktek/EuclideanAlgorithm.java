package src.Praktek;

public class EuclideanAlgorithm {
    public static int fpb(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int number1 = 17;
        int number2 = 33;

        int fpb = fpb(number1, number2);

        System.out.println("FPB dari " + number1 + " dan " + number2 + " adalah " + fpb);
    }
}
