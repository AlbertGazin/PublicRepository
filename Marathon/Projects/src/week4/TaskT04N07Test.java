package week4;

import static util.Assert.assertEquals;
import static week4.TaskT04N07.getSpiralArray;

public class TaskT04N07Test {
    public static void main(String[] args) {
        testSpiralArray();
    }

    public static void testSpiralArray() {
        int[][] expected = {{1, 2, 3, 4, 5, 6, 7}, {24, 25, 26, 27, 28, 29, 8}, {23, 40, 41, 42, 43, 30, 9}
                , {22, 39, 48, 49, 44, 31, 10}, {21, 38, 47, 46, 45, 32, 11}, {20, 37, 36, 35, 34, 33, 12}
                , {19, 18, 17, 16, 15, 14, 13}};
        assertEquals("Week4.TaskT04N07Test.testSpiralArray", expected, getSpiralArray(7));
    }
}
