package week1;

import java.util.Scanner;

public class TaskT01N05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int usd = scanner.nextInt();
        double course = scanner.nextDouble();
        System.out.println(usd + " USD = " + convertUsdToBtc(usd, course) + " bitcoins");
    }

    public static double convertUsdToBtc(int usd, double course) {
        if (usd < 0 || course < 0) {
            return -1;
        }
        return usd * course;
    }
}
