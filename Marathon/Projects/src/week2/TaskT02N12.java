package week2;

public class TaskT02N12 {
    public static void main(String[] args) {
        System.out.println(getAgeOfPerson(1985, 5, 2020, 5));
    }

    public static int getAgeOfPerson(int birthYear, int birthMonth, int currentYear, int currentMonth) {
        if (birthYear == currentYear) {
            return 1;
        }
        return birthMonth > currentMonth ? currentYear - birthYear - 1 : currentYear - birthYear;
    }
}
