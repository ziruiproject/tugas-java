import java.util.Scanner;
import java.lang.Math;

class Praktikum1 {
    public static void main(String[] args) {
        // PANGGIL METHOD DISINI
    }

    public static void No1(long a, long b) {
        long kpk = 1;
        for (long i = a; i <= b; i++) {
            kpk = getKPK(kpk, i);
        }
        System.out.println("KPK dari " + a + " s.d " + b + " adalah: " + kpk);
    }

    public static long getKPK(long a, long b) {
        return a * (b / getFPB(a, b));
    }

    public static long getFPB(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static String No2() {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukan x titik pertama: ");
        double x1 = input.nextDouble();
        System.out.println("Masukan y titik pertama: ");
        double y1 = input.nextDouble();
        System.out.println("Masukan x titik kedua: ");
        double x2 = input.nextDouble();
        System.out.println("Masukan y titik kedua: ");
        double y2 = input.nextDouble();
        input.close();

        double m;
        if (x2 == x1) {
            m = 0;
        }

        m = (y2 - y1) / (x2 - x1);
        y1 = y1 * -1;

        if (x1 < 0) {
            return "y = " + m + "(x + " + (x1 * -1) + ") + (" + y1 + ")";
        }
        return "y = " + m + "(x - " + x1 + ") + (" + y1 + ")";
    }

    public static void No3() {
        System.out.println("a\t\ta^2\tcbrt(a)");
        System.out.println("-------------------------------------------");

        for (int i = 1; i <= 10; i++) {
            System.out.print(i + "\t");
            System.out.print("\t" + i * i + "\t");
            System.out.println(Math.pow(i, (double) 1 / 3));
        }
    }

    public static void No4() {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukan besar sudut: ");
        double sudut = input.nextDouble();
        System.out.println("Masukan panjang jari-jari: ");
        double radius = input.nextDouble();

        input.close();
        double radian = sudut * (Math.PI / 180);
        double result = (sudut / 360 * Math.PI * radius * radius) - (radius * radius * Math.sin(radian) / 2);
        System.out.println("Luas tembereng adalah: " + result);
    }
}