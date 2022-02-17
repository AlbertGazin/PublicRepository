package week4;

import static util.Assert.assertEquals;
import static week4.TaskT04N02.elementFrequency;

public class TaskT04N02Test {
    public static void main(String[] args) {
        testEmptyArray();
        testArrayWithNegativeElements();
        testArrayWithOnlyOneElement();
        testArrayWithOneElement();
        testArrayWithDiffElements();
    }

    public static void testEmptyArray() {
        int[] actual = {};
        int[][] expected = {{-1}};
        assertEquals("Week4.TaskT04N02.testEmptyArray", expected, elementFrequency(actual));
    }

    public static void testArrayWithNegativeElements() {
        int[] actual = {3, -2, 0, 7, -2, 9, 0};
        int[][] expected = {{0, 2}, {-2, 2}, {3, 1}, {7, 1}, {9, 1}};
        assertEquals("Week4.TaskT04N02.testArrayWithNegativeElements", expected, elementFrequency(actual));
    }

    public static void testArrayWithOnlyOneElement() {
        int[] actual = {3};
        int[][] expected = {{3, 1}};
        assertEquals("Week4.TaskT04N02.testArrayWithOnlyOneElement", expected, elementFrequency(actual));
    }

    public static void testArrayWithOneElement() {
        int[] actual = {3, 3, 3, 3, 3};
        int[][] expected = {{3, 5}};
        assertEquals("Week4.TaskT04N02.testArrayWithOneElement", expected, elementFrequency(actual));
    }

    public static void testArrayWithDiffElements() {
        int[] actual = {3, -20, 7, 10, 3, 0, 19, 7, 4, 10, 10, 0};
        int[][] expected = {{0, 2}, {3, 2}, {-20, 1}, {19, 1}, {4, 1}, {7, 2}, {10, 3}};
        assertEquals("Week4.TaskT04N02.testArrayWithDiffElements", expected, elementFrequency(actual));
    }
}
