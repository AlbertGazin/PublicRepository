package week4;

import static util.Assert.assertEquals;
import static week4.TaskT04N01.fillArray;

public class TaskT04N01Test {
    public static void main(String[] args) {
        testZeroSize();
        testNegativeSize();
        testCorrectSize();
    }

    public static void testZeroSize() {
        int[] expected = {};
        assertEquals("Week4.TaskT04N01Test.testZeroSize", expected, fillArray(0));
    }

    public static void testNegativeSize() {
        int[] expected = {-1};
        assertEquals("Week4.TaskT04N01Test.testNegativeSize", expected, fillArray(-3));
    }

    public static void testCorrectSize() {
        int[] expected = {1, 2, 3, 4, 5};
        assertEquals("Week4.TaskT04N01Test.testCorrectSize", expected, fillArray(5));
    }
}
