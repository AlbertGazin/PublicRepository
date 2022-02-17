package week2;

import java.util.Scanner;

public class TaskT02N15 {
    private static final double[] ARRAY_ONE_TO_TWENTY = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double changeValue = scanner.nextDouble();
        double[] array = getArrayChangeUsdToRub(changeValue);
        for (double m : ARRAY_ONE_TO_TWENTY) {
            System.out.print(m + "\t");
        }
        System.out.println();
        for (double v : array) {
            System.out.print(v + "\t");
        }
        System.out.println();
    }

    public static double[] getArrayChangeUsdToRub(double changeValue) {
        double[] result = new double[ARRAY_ONE_TO_TWENTY.length];
        for (int i = 0; i < ARRAY_ONE_TO_TWENTY.length; i++) {
            result[i] = (i + 1) * changeValue;
        }
        return result;
    }
}
