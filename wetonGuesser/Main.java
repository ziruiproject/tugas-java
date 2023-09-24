package src.WetonGuesser;

import java.util.Scanner;

import src.WetonGuesser.Date;

public class Main {

    final static String[] days = new String[] {
            "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"
    };

    final static String[] weton = new String[] {
            "Pon", "Wage", "Kliwon", "Legi", "Pahing"
    };

    final static String[] months = new String[] {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli",
            "Agustus", "September", "Oktober", "November", "Desember"
    };

    private static void app() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan Tanggal Hari Lahir: ");
        short day = input.nextShort();
        for (int i = 0; i < months.length; i++) {
            System.out.print(i + 1 + ". " + months[i] + "\n");
        }
        System.out.print("Masukan Bulan Lahir (Angkanya Saja): ");
        short month = input.nextShort();
        System.out.print("Masukan Tahun Lahir: ");
        short year = input.nextShort();
        System.out.print("Masukan Nama Hari ini: ");
        String currentDay = input.next();
        System.out.print("Masukan Nama Pasaran Hari ini: ");
        String currentPasangan = input.next();
        // input.close();

        Date.currentDate[0] = day;
        Date.currentDate[1] = month;
        Date.currentDate[2] = year;

        Date Universal = new Date(days, currentDay);
        Date Weton = new Date(weton, currentPasangan);

        // System.out.println(Universal.getTotalDays());
        // System.out.println(Universal.getDaysDifference());

        System.out.println("\nTanggal Lahir: " + day + "/" + month + "/" + year);
        System.out.println("Hari lahir Anda: " + Universal.getDayName());
        System.out.println("Pasaran Anda: " + Weton.getDayName());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String isRepeat;

        do {
            app();
            System.out.print("Apakah Anda ingin mencoba lagi? (y/n): ");
            isRepeat = input.next();
        } while (isRepeat.equals("y"));

        input.close();

    }

}