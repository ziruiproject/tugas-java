import java.util.Scanner;

public class Quiz {
    // MAIN METHOD / FUNGSI UTAMA
    // Public static = modifier
    // Void, Int, Float, Double, String[] = Return Type
    // Main = Nama fungsi / method
    // Didalam kurung ada parameter
    public static void main(String[] args) {
        for (int i = 0; i <= baris; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        int baris = 8;
        for (;;)
            System.out.println("hello");

        if (baris == 8)
            System.out.println();

    }

    private static void No5() {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukan usia: ");
        int usia = input.nextInt();

        // USIA 0 - 13
        if (usia > 0 && usia <= 13) {
            System.out.println("Umur = " + usia + ", Klasifikasi Anak-anak");
        } else if (usia > 13 && usia <= 20) {
            System.out.println("Umur = " + usia + ", Klasifikasi Remaja");
        } else if (usia > 20 && usia <= 55) {
            System.out.println("Umur = " + usia + ", Klasifikasi Dewasa");
        } else if (usia > 55) {
            System.out.println("Umur = " + usia + ", Klasifikasi Manula");
        } else {
            System.out.println("Umur = " + usia + ", Klasifikasi Umur salah");
        }
    }

    private static void No1() {
        System.out.print(" | ");

        for (int j = 0; j < 4; j++)
            System.out.print(" " + j);

        System.out.println("\n---------------------");

        for (int i = 0; i < 4; i++) {
            System.out.print(i + " | ");
            for (int j = 1; j <= 4; j++) {
                System.out.printf("%4d", (i + j) % 4);
            }
            System.out.println();
        }

    }

    public static void swap(String s1, String s2) {
        String temp = s1;
        s1 = s2;
        s2 = temp;
        System.out.println("s1(1) = " + s1);
        System.out.println("s2(1) = " + s2);
    }

    private static void No2() {
        String s1 = "public static void swap(String s1, String s2) {\n" +
                " String temp = s1;\n s1 = s2;\n s2 = temp;\n" +
                " System.out.println(\"s1(1) = \" + s1);\n" +
                " System.out.println(\"s2(1) = \" + s2);";
        String s2 = "Rock";
        swap(s1, s2); // PASS BY VALUE
        System.out.println("s1(2) = " + s1);
        System.out.println("s2(2) = " + s2);
    }

    // METHOD
    // modifier, return type, nama method
    private static int mengkuadratkan(int num) {
        return num * num;
    }

    // private static int mengkuadratkan(double num) {
    // return (int) num * num;
    // }

}