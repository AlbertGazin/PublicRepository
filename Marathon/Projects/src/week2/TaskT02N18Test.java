package week2;

import static util.Assert.assertEquals;
import static week2.TaskT02N18.getNumbersArray;

public class TaskT02N18Test {
    public static void main(String[] args) {
        testZero();
        testNegativeNumber();
        testPositiveNumber();
    }

    public static void testZero() {
        double[] expected = {};
        assertEquals("Week2.TaskT02N18Test.testZero", expected, getNumbersArray(0));
    }

    public static void testNegativeNumber() {
        double[] expected = {};
        assertEquals("Week2.TaskT02N18Test.testNegativeNumber", expected, getNumbersArray(-3));
    }

    public static void testPositiveNumber() {
        double[] expected = {1.0, 4.0, 9.0};
        assertEquals("Week2.TaskT02N18Test.testPositiveNumber", expected, getNumbersArray(10));
    }
}
