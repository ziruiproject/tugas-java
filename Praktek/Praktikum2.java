import java.util.Scanner;

public class Praktikum2 {
    public static void main(String[] args) {
        int N = 0;
        double i = 0;
        while (N <= 100) {
            i += 0.1;
            System.out.println(i);
            N++;
        }

        System.out.println(i);
    }

    private static void No3() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan x1: ");
        double x1 = input.nextDouble();
        System.out.print("Masukan y1: ");
        double y1 = input.nextDouble();
        System.out.print("Masukan x2: ");
        double x2 = input.nextDouble();
        System.out.print("Masukan y2: ");
        double y2 = input.nextDouble();
        input.close();

        double dotProduct = (x1 * x2) + (y1 * y2);
        double a = Pythagoras(x1, y1);
        double b = Pythagoras(x2, y2);

        double teta = Math.acos(dotProduct / (a * b));
        teta = Math.abs(Math.toDegrees(teta));
        System.out.println("Sudut: " + teta);

        System.out.println("Jenis sudut: " + jenisSudut(teta));
    }

    private static double Pythagoras(double x, double y) {
        return Math.sqrt(Math.pow(x, 2) + (Math.pow(y, 2)));
    }

    private static String jenisSudut(double angle) {
        if (angle == 0) {
            return "Berimpit";
        } else if (angle > 0 && angle < 90) {
            return "Tumpul";
        } else if (angle == 90) {
            return "Siku-Siku";
        } else if (angle == 180) {
            return "Lurus";
        } else {
            return "Refleks";
        }
    }

    private static void No2() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan angka pertama: ");
        double x1 = input.nextDouble();
        System.out.print("Masukan angka pertama: ");
        double x2 = input.nextDouble();
        input.close();

        double a = 1;
        double b = -(x1 + x2);
        double c = x1 * x2;

        System.out.println("Apakah " + x1 + " merupakan hasil dari log " + x2 + "? : " + (Math.log(x2) == x1));
        System.out.println("Apakah " + x1 + " merupakan hasil dari sqrt(" + x2 + ")? : " + (Math.sqrt(x2) == x1));

        System.out.print("Kedua nilai tersebut dapat diperoleh dari persamaan kuadrat: ");
        System.out.println(a + "x^2 + " + b + "x + " + c + " = 0");
    }

    private static void No1() {
        String[] daysOfWeekMasehi = { "Jumat", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis" };
        String[] daysOfWeekWeton = { "Pon", "Wage", "Kliwon", "Legi", "Pahing" };

        Scanner input = new Scanner(System.in);
        System.out.print("Masukan hari (1-31): ");
        int day = input.nextInt();
        System.out.print("Masukan bulan (1-12): ");
        int month = input.nextInt();
        System.out.print("Masukan tahun: ");
        int year = input.nextInt();
        input.close();

        int acuanDay = 23;
        int acuanMonth = 10;
        int acuanYear = 2023;

        if (month < 3) {
            month += 12;
            year--;
        }

        int h = (day + 26 * (month + 1) / 10 + year + year / 4 + 5 * (year / 100) + year / 400);

        int hMasehi = h % 7;
        int hWeton = (h - (acuanDay + 26 * (acuanMonth + 1) / 10 + acuanYear + acuanYear / 4 + 5 * (acuanYear / 100)
                + acuanYear / 400)) % 5;

        hMasehi = (hMasehi + 7) % 7;
        hWeton = (hWeton + 5) % 5;

        String dayNameMasehi = daysOfWeekMasehi[hMasehi];
        String dayNameWeton = daysOfWeekWeton[hWeton];

        System.out.println("Nama hari dalam kalender masehi: " + dayNameMasehi);
        System.out.println("Nama hari dalam kalender weton: " + dayNameWeton);
    }
}
