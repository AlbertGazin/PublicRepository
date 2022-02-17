package week1;

import java.util.Scanner;

public class TaskT01N04 {
    private static final int SEC_IN_HOUR = 3600;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = scanner.nextInt();
        System.out.println("In " + hours + " hour(s) " + secondCount(hours) + " seconds");
    }

    public static int secondCount(int hours) {
        return hours * SEC_IN_HOUR;
    }
}
