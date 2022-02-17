package week2;

import static util.Assert.assertEquals;
import static week2.TaskT02N16.getAvgSumPurchase;

public class TaskT02N16Test {
    public static void main(String[] args) {
        testEmptyArray();
        testOneElement();
        testFourElements();
        testNegativeElement();
        testNegativeSum();
    }

    public static void testOneElement() {
        double[][] array = {{3}, {25}};
        double[] expected = {75};
        assertEquals("Week2.TaskT02N16Test.testOneElement", expected, getAvgSumPurchase(array));
    }

    public static void testFourElements() {
        double[][] array = {{1, 2, 2, 3}, {10, 10, 25, 5}};
        double[] expected = {10, 20, 50, 15};
        assertEquals("Week2.TaskT02N16Test.testFourElements", expected, getAvgSumPurchase(array));
    }

    public static void testEmptyArray() {
        double[][] array = {{}, {}};
        double[] expected = {};
        assertEquals("Week2.TaskT02N16Test.testEmptyArray", expected, getAvgSumPurchase(array));
    }

    public static void testNegativeElement() {
        double[][] array = {{5, 10, 12, -5}, {90, 82, 74, 35}};
        double[] expected = {};
        assertEquals("Week2.TaskT02N16Test.testNegativeElement", expected, getAvgSumPurchase(array));
    }

    public static void testNegativeSum() {
        double[][] array = {{5, 10, 12, 5}, {90, 82, -74, 35}};
        double[] expected = {};
        assertEquals("Week2.TaskT02N16Test.testNegativeSum", expected, getAvgSumPurchase(array));
    }
}
