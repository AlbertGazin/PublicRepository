package week1;

import static util.Assert.assertEquals;
import static week1.TaskT01N03.min;

public class TaskT01N03Test {
    public static void main(String[] args) {
        testFirstMin();
        testSecondMin();
        testThirdMin();
        testFourthMin();
        testFirstMinNegative();
        testSecondMinNegative();
        testThirdMinNegative();
        testFourthMinNegative();
        testAllEquals();
        testAllEqualsNegative();
        testAllNegative();
    }

    public static void testFirstMin() {
        assertEquals("Week1.TaskT01N03Test.testFirstMin", 3, min(3, 5, 7, 9));
    }

    public static void testSecondMin() {
        assertEquals("Week1.TaskT01N03Test.testSecondMin", 3, min(5, 3, 7, 9));
    }

    public static void testThirdMin() {
        assertEquals("Week1.TaskT01N03Test.testThirdMin", 3, min(5, 7, 3, 9));
    }

    public static void testFourthMin() {
        assertEquals("Week1.TaskT01N03Test.testFourthMin", 3, min(5, 7, 9, 3));
    }

    public static void testFirstMinNegative() {
        assertEquals("Week1.TaskT01N03Test.testFirstMinNegative", -3, min(-3, 5, 7, 9));
    }

    public static void testSecondMinNegative() {
        assertEquals("Week1.TaskT01N03Test.testSecondMinNegative", -3, min(5, -3, 7, 9));
    }

    public static void testThirdMinNegative() {
        assertEquals("Week1.TaskT01N03Test.testThirdMinNegative", -3, min(5, 7, -3, 9));
    }

    public static void testFourthMinNegative() {
        assertEquals("Week1.TaskT01N03Test.testFourthMinNegative", -3, min(5, 7, 9, -3));
    }

    public static void testAllNegative() {
        assertEquals("Week1.TaskT01N03Test.testAllNegative", -9, min(-5, -7, -9, -3));
    }

    public static void testAllEquals() {
        assertEquals("Week1.TaskT01N03Test.testAllEquals", 9, min(9, 9, 9, 9));
    }

    public static void testAllEqualsNegative() {
        assertEquals("Week1.TaskT01N03Test.testAllEqualsNegative", -9, min(-9, -9, -9, -9));
    }
}
