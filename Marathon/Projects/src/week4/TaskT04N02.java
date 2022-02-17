package week4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TaskT04N02 {
    public static void main(String[] args) {
        int[] array = {3, -20, 7, 10, 3, 0, 19, 7, 4, 10, 10, 0};
        System.out.println(Arrays.deepToString(elementFrequency(array)));
    }

    public static int[][] elementFrequency(int[] actualArray) {
        if (actualArray.length == 0) {
            return new int[][]{{-1}};
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < actualArray.length; i++) {
            if (map.containsKey(actualArray[i])) {
                map.replace(actualArray[i], map.get(actualArray[i]) + 1);
            } else {
                map.put(actualArray[i], 1);
            }
        }
        int[][] resultArray = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            resultArray[i][0] = entry.getKey();
            resultArray[i][1] = entry.getValue();
            i++;
        }
        return resultArray;
    }
}
