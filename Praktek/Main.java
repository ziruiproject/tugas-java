class Main {
    public static void main(String[] args) {
        double[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6.5, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        double result = 0;
        int diagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            result += matrix[i][diagonal];
            diagonal++;
        }

        System.out.println(result);
    }
}