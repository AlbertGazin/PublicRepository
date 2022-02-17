package week4;

import static util.Assert.assertEquals;
import static week4.TaskT04N05.drawArray1;
import static week4.TaskT04N05.drawArray2;

public class TaskT04N05Test {
    public static void main(String[] args) {
        testDraw1IfSizeEmpty();
        testDraw1IfSizeEven();
        testDraw1IfSizeOdd();
        testDraw2IfSizeEmpty();
        testDraw2IfSizeEven();
        testDraw2IfSizeOdd();
    }

    public static void testDraw1IfSizeEmpty() {
        int[][] expected = {};
        assertEquals("Week4.TaskT04N05Test.testDraw1IfSizeEmpty", expected, drawArray1(0, 0));
    }

    public static void testDraw1IfSizeOdd() {
        int[][] expected = {{1, 1, 1, 1, 1, 1, 1}, {1, 2, 3, 4, 5, 6, 7}, {1, 3, 6, 10, 15, 21, 28}
                , {1, 4, 10, 20, 35, 56, 84}, {1, 5, 15, 35, 70, 126, 210}, {1, 6, 21, 56, 126, 252, 462}
                , {1, 7, 28, 84, 210, 462, 924}};
        assertEquals("Week4.TaskT04N05Test.testDraw1IfSizeOdd", expected, drawArray1(7, 7));
    }

    public static void testDraw1IfSizeEven() {
        int[][] expected = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
                , {1, 3, 6, 10, 15, 21, 28, 36, 45, 55}, {1, 4, 10, 20, 35, 56, 84, 120, 165, 220}
                , {1, 5, 15, 35, 70, 126, 210, 330, 495, 715}, {1, 6, 21, 56, 126, 252, 462, 792, 1287, 2002}
                , {1, 7, 28, 84, 210, 462, 924, 1716, 3003, 5005}, {1, 8, 36, 120, 330, 792, 1716, 3432, 6435, 11440}
                , {1, 9, 45, 165, 495, 1287, 3003, 6435, 12870, 24310}
                , {1, 10, 55, 220, 715, 2002, 5005, 11440, 24310, 48620}
        };
        assertEquals("Week4.TaskT04N05Test.testDraw1IfSizeEven", expected, drawArray1(10, 10));
    }

    public static void testDraw2IfSizeEmpty() {
        int[][] expected = {{-1}};
        assertEquals("Week4.TaskT04N05Test.testDraw2IfSizeEmpty", expected, drawArray2(0, 0));
    }

    public static void testDraw2IfSizeOdd() {
        int[][] expected = {{1, 2, 3, 4, 5}, {2, 3, 4, 5, 1}, {3, 4, 5, 1, 2}, {4, 5, 1, 2, 3}, {5, 1, 2, 3, 4}};
        assertEquals("Week4.TaskT04N05Test.testDraw2IfSizeOdd", expected, drawArray2(5, 5));
    }

    public static void testDraw2IfSizeEven() {
        int[][] expected = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 1}
                , {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2}, {4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3}
                , {5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4}, {6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5}
                , {7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6}, {8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7}
                , {9, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8}, {10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9}
                , {11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}};
        assertEquals("Week4.TaskT04N05Test.testDraw2IfSizeEven", expected, drawArray2(12, 12));
    }
}
