package week2;

public class TaskT02N02 {
    public static void main(String[] args) {
        double[] array = {4, 7, 20.9, -5};
        System.out.println(getArrayElementsSum(array));
    }

    public static double getArrayElementsSum(double[] array) {
        double result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result;
    }
}
