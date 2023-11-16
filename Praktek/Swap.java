public class Swap {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 40; i++) {
            if (i % 5 == 0 || i % 10 == 0) {
                continue;
            }
            System.out.println(sum);
            sum += i;
        }
    }
}
