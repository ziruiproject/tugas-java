import java.util.Scanner;

public class Praktikum5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi posisi awal kubu penyerang dan penghadang
        int[] posisi = { 0, 10 }; // posisi[0] untuk kubu penyerang, posisi[1] untuk kubu penghadang

        // Array untuk menyimpan angka yang sudah digunakan oleh kubu penyerang
        boolean[] angkaYangSudahDitebak = new boolean[6]; // Indeks 1-5 digunakan untuk menyimpan informasi penggunaan
                                                          // angka

        // Memulai permainan
        while (true) {
            // Menampilkan posisi kubu penyerang dan penghadang
            System.out.println("Penyerang\tPenghadang");
            System.out.println(posisi[0] + "\t\t\t" + posisi[1]);

            // Meminta input angka tebakan dari kubu penyerang
            System.out.print("Masukkan angka tebakan (1-5): ");
            int tebakan = scanner.nextInt();

            // Memeriksa apakah angka sudah pernah digunakan
            if (angkaYangSudahDitebak[tebakan]) {
                System.out.println("Angka tersebut sudah digunakan. Coba lagi.");
                continue;
            }

            // Menandai angka tebakan sebagai sudah digunakan
            angkaYangSudahDitebak[tebakan] = true;

            // Menentukan pergerakan kubu penyerang berdasarkan aturan permainan
            if (tebakan > posisi[1]) {
                // Kubu penyerang bergerak sesuai angka tebakan
                posisi[0] += tebakan - posisi[1];
            } else if (tebakan < posisi[1]) {
                // Kubu penyerang dipukul mundur sejauh selisih dua angka tebakan
                posisi[0] -= (posisi[1] - tebakan) >= 2 ? 2 : posisi[1] - tebakan;
            }

            // Menentukan pergerakan kubu penghadang (secara acak)
            int tebakanPenghadang = (int) (Math.random() * 5) + 1;
            if (tebakanPenghadang > posisi[0]) {
                // Kubu penghadang bergerak sesuai angka tebakan
                posisi[1] -= tebakanPenghadang - posisi[0];
            }

            // Memeriksa apakah kubu penyerang sudah mencapai kubu penghadang
            if (posisi[0] >= posisi[1]) {
                System.out.println("Kubu penyerang berhasil mencapai kubu penghadang!");
                break;
            }
        }

        scanner.close();
    }
}
