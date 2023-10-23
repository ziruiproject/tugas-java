import java.util.Scanner;

class PerbaikanQuiz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan sebuah bilangan bulat positif: ");
        int angka = input.nextInt();
        int angkaAwal = angka;

        int jumlah = 0;

        while (angka != 0) {
            int sisa = angka % 2;
            if (sisa == 0) {
                jumlah += angka % 10;
            }
            angka = angka / 10;
        }

        System.out.println("Jumlah angka dasar genap dari " + angkaAwal + " adalah " + jumlah);
        input.close();
    }
}