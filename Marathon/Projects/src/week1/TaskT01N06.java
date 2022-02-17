package week1;

import java.util.Scanner;

public class TaskT01N06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double beginSum = scanner.nextDouble();
        double percent = scanner.nextDouble();
        int monthCount = scanner.nextInt();
        System.out.println("Percent = " + getSum(beginSum, percent, monthCount));
    }

    public static double getSum(double beginSum, double percent, int monthCount) {
        if (beginSum < 0 || percent < 0 || monthCount < 0) {
            return -1;
        }
        return beginSum * Math.pow((1 + percent / 12), monthCount);
    }
}
