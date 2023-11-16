// DEPRICATED

// package src.WetonGuesser;

// import java.util.Scanner;

// public class WetonGueser {
//     static int day;
//     static int month;
//     static int year;
//     static String currentDay;
//     static String currentWeton;
//     static long currentTime = System.currentTimeMillis();
//     static long[] dayDifference;

//     static String[] days = new String[] {
//             "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"
//     };

//     static String[] months = new String[] {
//             "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli",
//             "Agustus", "September", "Oktober", "November", "Desember"
//     };

//     static String[] weton = new String[] {
//             "Pon", "Wage", "Kliwon", "Legi", "Pahing"
//     };

//     static int[] daysInMonth = new int[] {
//             31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
//     };

//     public static void main(String[] args) {
//         // System.out.println((currentTime / 8.64e+7) - 6773);
//         Scanner input = new Scanner(System.in);
//         System.out.print("Masukan tanggal hari lahir: ");
//         day = input.nextInt();
//         System.out.println("""
//                 1. Januari
//                 2. Februari
//                 3. Maret
//                 4. April
//                 5. Mei
//                 6. Juni
//                 7. July
//                 8. Agustus
//                 9. September
//                 10. Oktober
//                 11. November
//                 12. Desember
//                 (Masukan nomornya saja)""");
//         System.out.print("Masukan bulan lahir: ");
//         month = input.nextInt();
//         System.out.print("Masukan tahun lahir: ");
//         year = input.nextInt();
//         System.out.println("Senin, Selasa, Rabu, Kamis, Jumat, Sabtu, Minggu");
//         System.out.print("Hari apa sekarang?: ");
//         currentDay = input.next();
//         System.out.println("Pon, Wage, Kliwon, Legi, Pahing");
//         System.out.print("Weton hari ini: ");
//         currentWeton = input.next();

//         input.close();

//         long epochDays = currentTime / 86400000;
//         long epochToBirthdayDays = getEpochDays();
//         long daysSinceBirthday = epochDays - epochToBirthdayDays;
//         long[] dayDifference = new long[2];
//         dayDifference[0] = (daysSinceBirthday % 7);
//         dayDifference[1] = (daysSinceBirthday % 5);

//         String birthDay = getDayName(days, currentDay, false);
//         String birthWeton = getDayName(weton, currentWeton, true);

//         System.out.println("Tanggal lahir: " + day + "/" + month + "/" + year);
//         System.out.println("Hari: " + birthDay);
//         System.out.println("Weton: " + birthWeton);
//     }

//     private static int getEpochDays() {
//         int totalDays = day;

//         // Convert Months to Days
//         for (int i = 0; i < month - 1; i++) {
//             totalDays += daysInMonth[i];
//         }

//         // Convert Years to Days
//         for (int i = 1970; i < year; i++) {
//             // System.out.println(i);
//             totalDays += isLeapYear(i) ? 366 : 365;
//         }
//         return totalDays;
//     }

//     private static boolean isLeapYear(int year) {
//         return (year % 100 != 0) && (year % 4 == 0);
//     }

//     private static int getArrayIndex(String[] array, String item) {
//         for (int i = 0; i < array.length; i++) {
//             if (array[i].equalsIgnoreCase(item)) {
//                 return i;
//             }
//         }
//         return -1;
//     }

//     private static String getDayName(String[] array, String currentDays, boolean weton) {
//         int dayIndex = getArrayIndex(array, currentDays);
//         if (dayIndex == -1) {
//             return "Hari tidak ditemukan atau Hari salah";
//         }
//         int birthDayIndex = dayIndex - (int) dayDifference[weton ? 1 : 0];
//         if (birthDayIndex >= 0) {
//             return array[birthDayIndex];
//         }
//         return array[(birthDayIndex % (weton ? 5 : 7)) + (weton ? 5 : 7)];
//     }

// }