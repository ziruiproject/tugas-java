public class SwitchCaseStatement {
    public static void main(String[] args) {
        char value = 'A';

        // With break
        switch (value) {
            case 'A':
                System.out.println("Anda lulus dengan sangat baik");
                break;
            case 'B':
                System.out.println("Anda lulus dengan baik");
                break;
            case 'C':
                System.out.println("Anda lulus");
                break;
            default:
                System.out.println("Mungkin Anda salah jurusan");
        }

        // Without break
        switch (value) {
            case 'A':
                System.out.println("Anda lulus dengan sangat baik");
            case 'B':
                System.out.println("Anda lulus dengan baik");
            case 'C':
                System.out.println("Anda lulus");
            default:
                System.out.println("Mungkin Anda salah jurusan");
        }

    }
}
