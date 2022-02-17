package week2;

import java.util.Arrays;

public class TaskT02N16 {
    public static void main(String[] args) {
        double[][] m = {{1, 3, 4}, {5, 6, 7}};
        System.out.println(Arrays.toString(getAvgSumPurchase(m)));
    }

    public static double[] getAvgSumPurchase(double[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < 0) {
                    return new double[0];
                }
            }
        }
        if (array.length > 0) {
            double[] result = new double[array[0].length];
            for (int j = 0; j < array[0].length; j++) {
                result[j] = array[0][j] * array[1][j];
            }
            return result;
        } else {
            return new double[0];
        }
    }
}
