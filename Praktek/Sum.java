package src.Praktek;

public class Sum {
    static int[] arr = new int[] {
            3, 7, 5, 4, 8, 9
    };

    public static void main(String[] args) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        System.out.println(result);
    }
}
