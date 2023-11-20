import java.util.Scanner;
import java.util.Random;

public class Praktikum5 {

    public static void main(String[] args) {

    }

    private static void No1() {
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

    private static final String[] kataOrang = { "Nathan", "Yesaya", "Takeshi", "Nanda" };
    private static final String[] kataBendaUmum = { "pria", "wanita", "ikan", "gajah", "kuda" };
    private static final String[] satuanBenda = { "seekor", "setiap", "beberapa", "seorang" };
    private static final String[] kataSifat = { "besar", "kecil", "cantik", "botak" };
    private static final String[] kataKerjaTidakTransitif = { "berlari", "melompat", "berbicara", "tidur" };
    private static final String[] kataKerjaTransitif = { "mencintai", "membenci", "melihat", "mengetahui", "mencari",
            "menemukan" };
    private static final String[] konjungsi = { "dan", "atau", "tapi", "karena" };

    public static void No2() {
        Random random = new Random();
        String kalimat = generateKalimat(random);
        System.out.println(kalimat);
    }

    private static String generateKalimat(Random random) {
        return capitalize(generateKalimatSederhana(random)) +
                (random.nextDouble() < 0.5
                        ? " " + konjungsi[random.nextInt(konjungsi.length)] + " " + generateKalimat(random)
                        : "");
    }

    private static String generateKalimatSederhana(Random random) {
        return generateFrasaBenda(random) + " " + generateFrasaKerja(random);
    }

    private static String generateFrasaBenda(Random random) {
        if (random.nextDouble() < 0.5) {
            return kataOrang[random.nextInt(kataOrang.length)];
        } else {
            return generateSatuanBenda(random) + (random.nextDouble() < 0.5 ? " " + generateKataSifat(random) : "") +
                    ". " + kataBendaUmum[random.nextInt(kataBendaUmum.length)] +
                    (random.nextDouble() < 0.5 ? " yang " + generateFrasaKerja(random) : "");
        }
    }

    private static String generateFrasaKerja(Random random) {
        if (random.nextDouble() < 0.25) {
            return kataKerjaTidakTransitif[random.nextInt(kataKerjaTidakTransitif.length)];
        } else if (random.nextDouble() < 0.5) {
            return kataKerjaTransitif[random.nextInt(kataKerjaTransitif.length)] + " " + generateFrasaBenda(random);
        } else if (random.nextDouble() < 0.75) {
            return "adalah " + generateKataSifat(random);
        } else {
            return "meyakini bahwa " + generateKataSederhana(random);
        }
    }

    private static String generateSatuanBenda(Random random) {
        return satuanBenda[random.nextInt(satuanBenda.length)];
    }

    private static String generateKataSifat(Random random) {
        return kataSifat[random.nextInt(kataSifat.length)];
    }

    private static String generateKataSederhana(Random random) {
        return kataOrang[random.nextInt(kataOrang.length)] + " " + generateFrasaKerja(random);
    }

    private static String capitalize(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
