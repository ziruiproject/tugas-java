public class Quiz1 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            if (i == 3) {
                i = 4;
            }
        }
    }

    public static void No1() {
        int i;
        for (i = 100; i >= 1; i++)
            System.out.println();
    }

    public static void No2() {
        int nilai = 6; // HARUSNYA GANJIL
        switch (nilai % 2) {
            case 0:
                System.out.println("Integer Genap");
                break;
            case 1:
                System.out.println("Integer Ganjil");
        }
    }

    public static void No3() {
        for (int i = 19; i >= 1; i += 2) {
            System.out.println(i);
        }
    }

    public static void No4() {
        double jumlah = 0;
        double k = 5;
        do {
            System.out.println(k);
            jumlah += 1.0 / k--;
        } while (k > 0);
        System.out.println("Jumlah = " + jumlah);
    }

    public static void HitungGenap(int angka) {
        int jumlah = 0;

        while (angka != 0) {
            int sisa = angka % 2;
            System.out.println(angka);
            System.out.println(sisa);
            if (sisa == 0) {
                jumlah += angka % 10;
            }
            angka = angka / 10;
        }

        System.out.println(jumlah);
    }

    public static void Bintang() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 4; k++) {
                    System.out.print('*');
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void getPi() {
        double jumlah = 0.0;
        boolean isAddition = true;

        for (int i = 1; i > 0; i += 2) {
            double angka = 4.0 / (double) i;

            if (isAddition) {
                jumlah += angka;
            } else {
                jumlah -= angka;
            }

            isAddition = !isAddition;

            System.out.println("jumlah = " + jumlah);
        }
    }

}
