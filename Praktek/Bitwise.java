package src.Praktek;

public class Bitwise {
    public static void main(String[] args) {
        int x = 1;
        int y = 5;
        System.out.println((x > 1) & (x++ < 10));
        x = 1;
        System.out.println((x > 1) && (x++ < 10));
        x = 1;

        int binary1 = 0b00000010;
        int binary2 = 0b00000110;
        int result = 0b00000000;
        System.out.println(binary1 & binary2);
        System.out.println(2 & 5);
        System.out.println(2 | 4);

        System.out.println((x > y) && (x < y));
    }
}
