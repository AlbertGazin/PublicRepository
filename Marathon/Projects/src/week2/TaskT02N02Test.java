package week2;

import static util.Assert.assertEquals;
import static week2.TaskT02N02.getArrayElementsSum;

public class TaskT02N02Test {
    public static void main(String[] args) {
        testSum1();
        testIfAllNegative();
        testIfAllZero();
        testIfArrayHasNegativePositiveAndZero();
    }

    public static void testSum1() {
        double[] k = {10, 20, 30, 10};
        assertEquals("Week2.TaskT02N02Test.test1", 70, getArrayElementsSum(k));
    }

    public static void testIfAllNegative() {
        double[] k = {-10, -20, -30};
        assertEquals("Week2.TaskT02N02Test.testIfAllNegative", -60, getArrayElementsSum(k));
    }

    public static void testIfAllZero() {
        double[] k = {0, 0, 0};
        assertEquals("Week2.TaskT02N02Test.testIfAllZero", 0, getArrayElementsSum(k));
    }

    public static void testIfArrayHasNegativePositiveAndZero() {
        double[] k = {-5, 90, 0, -3, 2};
        assertEquals("Week2.TaskT02N02Test.testIfArrayHasNegativePositiveAndZero", 84, getArrayElementsSum(k));
    }
}
