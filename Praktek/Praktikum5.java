import java.util.Scanner;
import java.util.Random;

public class Praktikum5 {

    public static void main(String[] args) {
        No3();
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
                    ". " + capitalize(kataBendaUmum[random.nextInt(kataBendaUmum.length)]) +
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
        StringBuilder result = new StringBuilder(str.length());
        boolean capitalizeNext = true;

        for (char charAt : str.toCharArray()) {
            if (capitalizeNext) {
                result.append(Character.toUpperCase(charAt));
                capitalizeNext = false;
            } else {
                result.append(charAt);
            }

            if (charAt == ' ' || charAt == '.') {
                capitalizeNext = true;
            }
        }

        return result.toString();
    }

    private static final String[] kataKunci = {
            "programming", "java", "hangman", "computer", "algorithm",
            "python", "javascript", "developer", "database", "android",
            "interface", "encryption", "network", "security", "software",
            "internet", "framework", "responsive", "application", "tutorial",
            "machine", "learning", "artificial", "intelligence", "virtual",
            "reality", "augmented", "blockchain", "typescript", "angular",
            "react", "nodejs", "mongodb", "firebase", "spring", "hibernate",
            "authentication", "authorization", "docker", "kubernetes", "serverless",
            "responsive", "frontend", "backend", "fullstack", "web",
            "responsive", "mobile", "desktop", "cloud", "agile",
            "programming", "language", "compiler", "debugging", "optimization",
            "variable", "function", "iteration", "recursion", "array",
            "linkedlist", "queue", "stack", "sorting", "searching",
            "tree", "graph", "dynamic", "static", "polymorphism",
            "inheritance", "encapsulation", "abstraction", "interface", "object",
            "class", "instance", "variable", "method", "constructor",
            "destructor", "override", "overload", "exception", "trycatch"
    };

    public static void No3() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean bermain = true;
        while (bermain) {
            String kataRahasia = kataKunci[random.nextInt(kataKunci.length)].toLowerCase();
            StringBuilder kataTebakan = new StringBuilder("*".repeat(kataRahasia.length()));
            StringBuilder hurufTebakan = new StringBuilder();
            int kesalahan = 0;

            System.out.println("Selamat datang di Hangman!");
            System.out.println("Anda memiliki maksimal 9 kesalahan untuk menebak kata.");

            while (kataTebakan.indexOf("*") != -1 && kesalahan < 9) {
                System.out.println("(Tebak) Kata: " + kataTebakan);
                System.out.println("Huruf yang sudah ditebak: " + hurufTebakan);
                System.out.println("Masukkan huruf tebakan: ");
                char tebakan = scanner.next().toLowerCase().charAt(0);

                if (!Character.isLetter(tebakan)) {
                    System.out.println("Masukkan huruf yang valid.");
                    continue;
                }

                if (hurufTebakan.indexOf(String.valueOf(tebakan)) != -1) {
                    System.out.println("Anda sudah menebak huruf ini sebelumnya. Coba lagi.");
                    continue;
                }

                hurufTebakan.append(tebakan);

                if (kataRahasia.indexOf(tebakan) != -1) {
                    System.out.println("Tebakan benar!");
                    kataTebakan = updateKataTebakan(kataRahasia, kataTebakan, tebakan);
                } else {
                    kesalahan++;
                    System.out.println("Tebakan salah. Anda telah salah sebanyak " + kesalahan + " kali.");
                }
            }

            if (kataTebakan.indexOf("*") == -1) {
                System.out.println("Selamat, Anda berhasil menebak kata! Kata rahasianya adalah " + kataRahasia + ".");
            } else {
                System.out
                        .println("Maaf, Anda tidak berhasil menebak kata. Kata rahasianya adalah " + kataRahasia + ".");
            }

            System.out.println("Mau bermain lagi? (y/n): ");
            char jawaban = scanner.next().toLowerCase().charAt(0);
            bermain = (jawaban == 'y');
        }

        System.out.println("Terima kasih telah bermain Hangman!");
        scanner.close();
    }

    private static StringBuilder updateKataTebakan(String kataRahasia, StringBuilder kataTebakan, char tebakan) {
        for (int i = 0; i < kataRahasia.length(); i++) {
            if (kataRahasia.charAt(i) == tebakan) {
                kataTebakan.setCharAt(i, tebakan);
            }
        }
        return kataTebakan;
    }
}
