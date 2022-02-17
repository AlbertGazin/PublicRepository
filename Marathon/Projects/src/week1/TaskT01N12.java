package week1;

public class TaskT01N12 {
    private final static int degree = 360 / 12; // 360 градусов / 12 = 30 градусов на 1 час.
    private final static int minutesInOneHour = 60;
    private final static int secondsInOneHour = minutesInOneHour * 60;

    public static void main(String[] args) {
        System.out.println(getAngleValue(18, 0, 0));
    }

    public static double getAngleValue(int hour, int minutes, int seconds) {
        if (hour > 0 && hour <= 23 && minutes >= 0 && minutes <= 59 && seconds >= 0 && seconds <= 59) {
            if (hour - 12 > 0) {
                hour -= 12;
            }
            return getAngleForHour(hour) + getAngleForMinutes(minutes) + getAngleForSeconds(seconds);
        } else return -1;
    }

    private static double getAngleForHour(int hour) {
        return (double) hour * degree;
    }

    private static double getAngleForMinutes(int minutes) {
        return (double) minutes * degree / minutesInOneHour;
    }

    private static double getAngleForSeconds(int seconds) {
        return (double) seconds * degree / secondsInOneHour;
    }
}
