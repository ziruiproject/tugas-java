package src.WetonGuesser;

public class Date {

    static short[] currentDate = new short[3];

    static int[] daysInMonth = new int[] {
            31, isLeapYear(currentDate[2]) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    long currentTime = System.currentTimeMillis();
    String[] days;
    int daysInWeek;
    String currentDay;

    private static boolean isLeapYear(short year) {
        return ((year % 4 == 0) && (year % 100 != 0));
    }

    private int getTotalDays() {
        int totalDays = currentDate[0];

        for (int i = 0; i < currentDate[1] - 1; i++) {
            totalDays += daysInMonth[i];
        }

        for (int i = 1970; i < currentDate[2]; i++) {
            totalDays += isLeapYear((short) i) ? 366 : 365;
        }

        return totalDays;
    }

    private int getDaysDifference() {
        return (int) (((currentTime / 86400000) - getTotalDays()) % this.daysInWeek);
    }

    private int getArrayIndex(String item) {
        for (int i = 0; i < days.length; i++) {
            if (this.days[i].equalsIgnoreCase(item)) {
                return i;
            }
        }
        return -1;
    }

    public String getDayName() {
        int currentDayIndex = this.getArrayIndex(this.currentDay);
        if (currentDayIndex == -1) {
            return "Hari tidak ditemukan atau salah";
        }
        int birthDayIndex = currentDayIndex - getDaysDifference();
        if (birthDayIndex >= 0) {
            return days[birthDayIndex];
        }

        birthDayIndex = ((birthDayIndex % this.daysInWeek) + this.daysInWeek);
        return days[birthDayIndex];
    }

    public Date(String[] days, String currentDay) {
        this.days = days;
        this.daysInWeek = days.length;
        this.currentDay = currentDay;
    }

}