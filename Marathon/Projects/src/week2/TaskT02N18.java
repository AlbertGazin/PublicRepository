package week2;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskT02N18 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNumbersArray(9)));
    }

    public static double[] getNumbersArray(int number) {
        ArrayList<Integer> resultArrayList = new ArrayList<>();
        for (int i = 1; i * i < number; i++) {
            resultArrayList.add(i * i);
        }
        double[] resultArray = new double[resultArrayList.size()];
        for (int i = 0; i < resultArrayList.size(); i++) {
            resultArray[i] = resultArrayList.get(i);
        }
        return resultArray;
    }
}
