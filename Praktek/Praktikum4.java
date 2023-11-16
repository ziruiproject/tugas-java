import java.util.Scanner;

class Praktikum4 {

    public static void main(String[] args) {
        No3();
    }

    private static void No1() {
        String[] nominales = {
                "",
                "satu",
                "dua",
                "tiga",
                "empat",
                "lima",
                "enam",
                "tujuh",
                "delapan",
                "sembilan"
        };

        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        int angka = input.nextInt();
        input.close();

        String hasil = terbilangRekursif(angka, nominales);
        hasil = hasil.replaceAll("satu ratus", "seratus");

        System.out.println(angka + " dalam terbilang: " + (hasil.isEmpty() ? "Nol" : hasil));
    }

    private static String terbilangRekursif(int angka, String[] nominales) {
        if (angka < 10) {
            return nominales[angka];
        } else if (angka < 20) {
            return nominales[angka - 10] + " belas";
        } else if (angka < 100) {
            return nominales[angka / 10] + " puluh " + terbilangRekursif(angka % 10, nominales);
        } else if (angka == 100) {
            return "seratus";
        } else if (angka < 1000) {
            return nominales[angka / 100] + " ratus " + terbilangRekursif(angka % 100, nominales);
        } else if (angka < 1000000) {
            return terbilangRekursif(angka / 1000, nominales) + " ribu " + terbilangRekursif(angka % 1000, nominales);
        } else {
            return terbilangRekursif(angka / 1000000, nominales) + " juta "
                    + terbilangRekursif(angka % 1000000, nominales);
        }
    }

    private static void No2() {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan panjang alfabet: ");
        int panjang = input.nextInt();

        input.close();

        permutasi(panjang);
    }

    private static void permutasi(char[] characters, int panjang, String current) {
        if (panjang == 0) {
            System.out.println(current);
            return;
        }
        for (char character : characters) {
            permutasi(characters, panjang - 1, current + character);
        }
    }

    private static void permutasi(int n) {
        char[] characters = new char[n];
        for (int i = 0; i < n; i++) {
            characters[i] = (char) ('a' + i);
        }

        permutasi(characters, n, "");
    }

    private static void No3() {
        Scanner input = new Scanner(System.in);

        System.out.print("Banyak irisan pare: ");
        int n = input.nextInt();

        System.out.println("Siapa yang jalan duluan?");
        System.out.println("1. Nathan");
        System.out.println("2. Yesaya");

        System.out.print("Masukkan entri (1 atau 2): ");
        String[] players = { "Nathan", "Yesaya" };
        int player = input.nextInt();

        input.close();

        System.out
                .println("Pemenangnya adalah " + (n % 2 != 0 ? players[player - 1] : players[players.length - player]));

    }
}
