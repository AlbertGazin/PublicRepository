package week2;

import static util.Assert.assertEquals;
import static week2.TaskT02N04.getSumDigitsOfNumber;

public class TaskT02N04Test {
    public static void main(String[] args) {
        testSumOf1234();
        testSumOf7000();
        testSumOfNegativeNumber();
    }

    public static void testSumOf1234() {
        assertEquals("Week2.TaskT02N04Test.testSumOf1234", 10, getSumDigitsOfNumber(1234));
    }

    public static void testSumOf7000() {
        assertEquals("Week2.TaskT02N04Test.testSumOf7000", 7, getSumDigitsOfNumber(7000));
    }

    public static void testSumOfNegativeNumber() {
        assertEquals("Week2.TaskT02N04Test.testSumOfNegativeNumber", -1, getSumDigitsOfNumber(-555));
    }
}
