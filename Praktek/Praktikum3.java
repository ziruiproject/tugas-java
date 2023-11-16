import java.util.Scanner;
import java.lang.Math;

public class Praktikum3 {
    public static void main(String[] args) {
        No3();
    }

    private static void No1(int batas, int a, int b, int c) {
        int count = 0;

        for (int i = 1; i < batas; i++) {
            if (i % a == 0 || i % b == 0 || i % c == 0) {
                count++;
            }
        }

        System.out.println("Jumlah bilangan asli yang kurang dari " + batas +
                " yang merupakan kelipatan dari " + a + ", " + b + ", atau " + c + " adalah: " + count);
    }

    private static void No2() {
        Scanner input = new Scanner(System.in);

        System.out.println(
                "Metode biseksi untuk persamaan x^7 + 21x^6 + 69x^5 - 1245x^4 - 9366x^3 + 2904x^2 + 175616x + 376320");
        System.out.print("Masukkan a: ");
        double a = input.nextDouble();
        System.out.print("Masukkan b: ");
        double b = input.nextDouble();

        input.close();

        double tolerasnsi = 1e-9; // Toleransi
        double p, fa, fp;

        System.out.println("\nHasil iterasi:");
        System.out.println("p\tf(p)\tf(a) * f(p)");

        if (function(a) * function(b) >= 0) {
            System.out.println("Tidak memenuhi syarat (f(a) * f(b) >= 0).");
            return;
        }

        do {
            p = (a + b) / 2;
            fa = function(a);
            fp = function(p);

            System.out.println(p + "\t" + fp + "\t" + (fa * fp));

            if (fa * fp < 0) {
                b = p;
            } else {
                a = p;
            }

        } while (!(Math.abs(fp) < tolerasnsi));
    }

    private static double function(double x) {
        return Math.pow(x, 7) + 21 * Math.pow(x, 6) + 69 * Math.pow(x, 5) - 1245 * Math.pow(x, 4)
                - 9366 * Math.pow(x, 3) + 2904 * Math.pow(x, 2) + 175616 * x + 376320;
    }

    private static void No3() {
        Scanner input = new Scanner(System.in);

        System.out.println("Selamat datang di permainan Mystery Door BNS!");
        System.out.print("Masukkan peluang awal (0 < x < 1): ");
        double x = input.nextDouble();

        if (x <= 0 || x >= 1) {
            System.out.println("Peluang awal harus berada di antara 0 dan 1.");
            return;
        }

        System.out.print("Masukkan peluang tambahan (0 < k <= 0.1): ");
        double k = input.nextDouble();

        if (k <= 0 || k > 0.1) {
            System.out.println("Peluang tambahan harus berada di antara 0 dan 0.1.");
            return;
        }

        int steps = 0;
        int pintu;
        boolean win = false;

        while (!win) {
            pintu = selectDoor(x);
            steps++;

            System.out.print("Langkah ke-" + steps + ", Pilih pintu (1, 2, atau 3): ");
            int userInput = input.nextInt();

            if (userInput < 1 || userInput > 3) {
                System.out.println("Pilihan tidak valid. Pilih pintu 1, 2, atau 3.");
                continue;
            }

            if (userInput == 1) {
                if (pintu == 1) {
                    System.out.println("Selamat! Anda memilih pintu yang benar!");
                    win = true;
                } else {
                    System.out.println("Oh tidak! Anda memasuki pintu jebakan");
                    x += k;
                    if (x >= 1) {
                        System.out.println("Anda menang setelah " + steps + " langkah.");
                        break;
                    }
                }
            } else {
                System.out.println("Pintu yang Anda pilih adalah pintu jebakan");
                x += k;
                if (x >= 1) {
                    System.out.println("Anda menang setelah " + steps + " langkah.");
                    break;
                }
            }
        }
    }

    private static int selectDoor(double x) {
        double random = Math.random();
        if (random < x) {
            return 1;
        } else if (random < x + (1 - x) / 3) {
            return 2;
        } else {
            return 3;
        }
    }

}
