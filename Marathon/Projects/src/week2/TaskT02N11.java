package week2;

public class TaskT02N11 {
    private static final int FIRST_DAY_IN_YEAR = 1;
    private static final int LAST_DAY_IN_YEAR = 365;

    public static void main(String[] args) {
        System.out.println(getInfoAboutDay(41));
    }

    public static String getInfoAboutDay(int dayNumber) {
        if (dayNumber >= FIRST_DAY_IN_YEAR && dayNumber <= LAST_DAY_IN_YEAR) {
            if (dayNumber % 7 == 0 || dayNumber % 7 == 6) {
                return "Weekend";
            } else {
                return "Workday";
            }
        } else {
            return "Day should be between " + FIRST_DAY_IN_YEAR + " and " + LAST_DAY_IN_YEAR;
        }
    }
}
