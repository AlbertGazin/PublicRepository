package week2;

public class TaskT02N03 {
    public static void main(String[] args) {
        double[] array = {10, -5, 60, 32};
        System.out.println(getMaxFromArray(array));
    }

    public static double getMaxFromArray(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
