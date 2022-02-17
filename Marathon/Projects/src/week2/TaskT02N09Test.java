package week2;

import static util.Assert.assertEquals;
import static week2.TaskT02N09.sortArray;

public class TaskT02N09Test {
    public static void main(String[] args) {
        testArr1();
        testIfAllElementsEqual();
        testIfAllElementsNegative();
        testIfAllElementsZero();
        testIfOneElement();
    }

    public static void testArr1() {
        double[] m = {41, 72, 5, 23, 54};
        double[] expected = {5, 23, 41, 54, 72};
        assertEquals("Week2.TaskT02N09Test.testArr1", expected, sortArray(m));
    }

    public static void testIfAllElementsZero() {
        double[] m = {0, 0, 0, 0, 0};
        assertEquals("Week2.TaskT02N09Test.testIfAllElementsZero", m, sortArray(m));
    }

    public static void testIfAllElementsNegative() {
        double[] m = {-1, -26, -5, -37, -451};
        double[] expected = {-451, -37, -26, -5, -1};
        assertEquals("Week2.TaskT02N09Test.testIfAllElementsNegative", expected, sortArray(m));
    }

    public static void testIfAllElementsEqual() {
        double[] m = {45, 45, 45, 45, 45};
        assertEquals("Week2.TaskT02N09Test.testIfAllElementsEqual", m, sortArray(m));
    }

    public static void testIfOneElement() {
        double[] m = {5};
        assertEquals("Week2.TaskT02N09Test.testIfOneElement", m, sortArray(m));
    }
}
