package week1;

import static util.Assert.assertEquals;
import static week1.TaskT01N01.max;

public class TaskT01N01Test {
    public static void main(String[] args) {
        testFirstMax();
        testSecondMax();
        testFirstMaxNegative();
        testSecondMaxNegative();
    }

    public static void testFirstMax() {
        assertEquals("Week1.TaskT01N01Test.testFirstMax", 4, max(4, 3));
    }

    public static void testSecondMax() {
        assertEquals("Week1.TaskT01N01Test.testSecondMax", 7, max(5, 7));
    }

    public static void testFirstMaxNegative() {
        assertEquals("Week1.TaskT01N01Test.testFirstMaxNegative", -10, max(-10, -15));
    }

    public static void testSecondMaxNegative() {
        assertEquals("Week1.TaskT01N01Test.testSecondMaxNegative", -3, max(-9, -3));
    }
}
