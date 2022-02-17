package week2;

public class TaskT02N17 {
    private final static int ITERATION = 100;
    private final static int DISTANCE = 1000;

    public static void main(String[] args) {
        System.out.println(getMetersToHome());
        System.out.println(getSumMeters());
    }

    public static double getMetersToHome() {
        double beginPoint = 0;

        for (int i = 1; i <= ITERATION; i += 2) {
            beginPoint += (double) DISTANCE / i;
        }

        for (int i = 2; i <= ITERATION; i += 2) {
            beginPoint -= (double) DISTANCE / i;
        }
        return beginPoint;
    }

    public static double getSumMeters() {
        double sumMeters = DISTANCE;
        for (int i = 2; i <= ITERATION; i++) {
            sumMeters += (double) DISTANCE / i;
        }
        return sumMeters;
    }
}
