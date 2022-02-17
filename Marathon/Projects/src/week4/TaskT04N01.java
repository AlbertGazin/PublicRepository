package week4;

import java.util.Arrays;

public class TaskT04N01 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fillArray(-3)));
    }

    public static int[] fillArray(int arraySize) {
        if (arraySize < 0) {
            return new int[]{-1};
        }
        int[] resultArray = new int[arraySize];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = i + 1;
        }
        return resultArray;
    }
}
