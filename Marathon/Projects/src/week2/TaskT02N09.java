package week2;

public class TaskT02N09 {
    public static void main(String[] args) {
        double[] array = {20, 5, 0, 7, 2, 8};
        double[] sortedArray = sortArray(array);
        for (double v : sortedArray) {
            System.out.println(v);
        }
    }

    public static double[] sortArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    double tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }
}
