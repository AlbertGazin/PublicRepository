package week2;

import static util.Assert.assertEquals;
import static week2.TaskT02N01.getAvgNumber;

public class TaskT02N01Test {
    public static void main(String[] args) {
        testAvg20();
        testAvg55();
        testAllNumbersEqual();
        testTwoNumbersEqual();
        testIfOneNumberZero();
        testIfTwoNumbersZero();
        testIfThreeNumbersZero();
        testIfOneNumberNegative();
        testIfTwoNumbersNegative();
        testIfThreeNumbersNegative();
    }

    public static void testAvg20() {
        assertEquals("Week2.TaskT02N01Test.testAvg20", 20, getAvgNumber(20, 40, 10));
    }

    public static void testAvg55() {
        assertEquals("Week2.TaskT02N01Test.testAvg55", 55, getAvgNumber(67, 43, 55));
    }

    public static void testIfOneNumberZero() {
        assertEquals("Week2.TaskT02N01Test.testIfOneNumberZero", 55, getAvgNumber(67, 0, 55));
    }

    public static void testIfTwoNumbersZero() {
        assertEquals("Week2.TaskT02N01Test.testIfTwoNumbersZero", 0, getAvgNumber(0, 0, 55));
    }

    public static void testIfThreeNumbersZero() {
        assertEquals("Week2.TaskT02N01Test.testIfThreeNumbersZero", 0, getAvgNumber(0, 0, 0));
    }

    public static void testIfOneNumberNegative() {
        assertEquals("Week2.TaskT02N01Test.testIfOneNumberNegative", 0, getAvgNumber(-67, 0, 55));
    }

    public static void testIfTwoNumbersNegative() {
        assertEquals("Week2.TaskT02N01Test.testIfTwoNumbersNegative", -50, getAvgNumber(-50, 34, -55));
    }

    public static void testIfThreeNumbersNegative() {
        assertEquals("Week2.TaskT02N01Test.testIfThreeNumbersNegative", -30, getAvgNumber(-5, -30, -45));
    }

    public static void testAllNumbersEqual() {
        assertEquals("Week2.TaskT02N01Test.testAllNumbersEqual", 20, getAvgNumber(20, 20, 20));
    }

    public static void testTwoNumbersEqual() {
        assertEquals("Week2.TaskT02N01Test.testTwoNumbersEqual", 40, getAvgNumber(20, 40, 40));
    }
}
