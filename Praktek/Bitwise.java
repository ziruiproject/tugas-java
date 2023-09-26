package src.Praktek;

public class Bitwise {
    public static void main(String[] args) {
        int x = 1;
        int y = 5;

        System.out.println((x > 1) & (x++ < 10));
        // Same as
        System.out.println(false & true);
        System.out.println(0b00000000 & 0b00000001);
        x = 1;
        System.out.println((x > 1) && (x++ < 10));
        // Same as
        System.out.println(false && true);
        // But can't do bitwise
        // System.out.println(0b00000000 && 0b00000001);
        x = 1;

        // Bitwise operator will covert integer to binary, then it will applly
        // the operation to each bits

        // Eg for and bitwise operator
        int binaryOfX = 0b00000001;
        int binaryOfY = 0b00000101;
        int resultOfAnd = 0b00000001;
        int resultOfOr = 0b00000101;

        System.out.println(binaryOfX & binaryOfY);
        // Same as
        System.out.println(1 & 5);

        // Another example
        int a = 27;
        int b = 74;
        int binaryA = 0b00011011;
        int binaryB = 0b01001010;
        int result = 0b00001010;
        System.out.println(2 | 4);

        System.out.println((x > y) && (x < y));
    }
}
