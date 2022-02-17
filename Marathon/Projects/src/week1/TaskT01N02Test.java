package week1;

import static util.Assert.assertEquals;
import static week1.TaskT01N02.min;

public class TaskT01N02Test {
    public static void main(String[] args) {
        testFirstMin();
        testSecondMin();
        testThirdMin();
        testFirstMinNegative();
        testSecondMinNegative();
        testThirdMinNegative();
        testAllEqualsMin();
        testAllNegativeEqualsMin();
        testAllNegativeMin();
    }

    public static void testFirstMin() {
        assertEquals("Week1.TaskT01N02Test.testFirstMin", 1, min(1, 20, 5));
    }

    public static void testSecondMin() {
        assertEquals("Week1.TaskT01N02Test.testSecondMin", 3, min(10, 3, 5));
    }

    public static void testThirdMin() {
        assertEquals("Week1.TaskT01N02Test.testThirdMin", 5, min(10, 20, 5));
    }

    public static void testFirstMinNegative() {
        assertEquals("Week1.TaskT01N02Test.testFirstMinNegative", -10, min(-10, 20, -5));
    }

    public static void testSecondMinNegative() {
        assertEquals("Week1.TaskT01N02Test.testSecondMinNegative", -20, min(10, -20, 5));
    }

    public static void testThirdMinNegative() {
        assertEquals("Week1.TaskT01N02Test.testThirdMinNegative", -5, min(10, 20, -5));
    }

    public static void testAllEqualsMin() {
        assertEquals("Week1.TaskT01N02Test.testAllEqualsMin", 5, min(5, 5, 5));
    }

    public static void testAllNegativeMin() {
        assertEquals("Week1.TaskT01N02Test.testAllNegativeMin", -20, min(-10, -20, -5));
    }

    public static void testAllNegativeEqualsMin() {
        assertEquals("Week1.TaskT01N02Test.testAllNegativeEqualsMin", -20, min(-20, -20, -20));
    }
}
