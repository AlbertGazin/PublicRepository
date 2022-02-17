package week1;

import static util.Assert.assertEquals;
import static week1.TaskT01N10.reverseNumber;

public class TaskT01N10Test {
    public static void main(String[] args) {
        testIfNumberLessThan100();
        testIfNumberMoreThan1000();
        testIfThreeEqualDigits();
        testIfMirrorNumber();
        testIfNumberHasTwoZero();
    }

    public static void testIfNumberLessThan100() {
        assertEquals("Week1.TaskT01N10Test.testIfNumberLessThan100", -1, reverseNumber(7));
    }

    public static void testIfNumberMoreThan1000() {
        assertEquals("Week1.TaskT01N10Test.testIfNumberMoreThan1000", -1, reverseNumber(7654));
    }

    public static void testIfThreeEqualDigits() {
        assertEquals("Week1.TaskT01N10Test.testIfThreeEqualDigits", 555, reverseNumber(555));
    }

    public static void testIfMirrorNumber() {
        assertEquals("Week1.TaskT01N10Test.testIfMirrorNumber", 808, reverseNumber(808));
    }

    public static void testIfNumberHasTwoZero() {
        assertEquals("Week1.TaskT01N10Test.testIfNumberHasTwoZero", 4, reverseNumber(400));
    }
}
