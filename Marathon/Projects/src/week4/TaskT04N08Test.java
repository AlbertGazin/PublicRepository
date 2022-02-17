package week4;

import static util.Assert.assertEquals;
import static week4.TaskT04N08.getAvgStudentCount;

public class TaskT04N08Test {
    public static void main(String[] args) {
        testAvgCount();
    }

    public static void testAvgCount() {
        int[][] actual = {{10, 10, 10, 10}, {11, 11, 11, 11}, {12, 12, 12, 12}, {13, 13, 13, 13}, {14, 14, 14, 14}
                , {15, 15, 15, 15}, {16, 16, 16, 16}, {17, 17, 17, 17}, {18, 18, 18, 18}, {19, 19, 19, 19}
                , {0, 0, 0, 0}};
        int[][] expected = {{10}, {11}, {12}, {13}, {14}, {15}, {16}, {17}, {18}, {19}, {0}};
        assertEquals("Week4.TaskT04N08Test.testAvgCount", expected, getAvgStudentCount(actual));
    }
}
