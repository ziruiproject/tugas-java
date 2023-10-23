import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var hasil = kali(1, 2);
        System.out.println(hasil);

    }

    private static int kali(int num1, int num2) {
        return num1 * num2;
    }

    private static String kali(String num1, int num2) {
        return "num1 * num2";
    }
}