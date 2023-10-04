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
        System.out.println((1 == x) | (10 > x++));
        // Same as
        System.out.println(true | false);
        System.out.println(0b1 | 0b0);
        x = 1;
        System.out.println((1 == x) || (10 > x++));

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
        int resultBitwiseAnd = 0b00001010;
        int resultBitwiseOr = 0b01011011;
        System.out.println(binaryA & binaryB);
        System.out.println(binaryA | binaryB);
    }
}
