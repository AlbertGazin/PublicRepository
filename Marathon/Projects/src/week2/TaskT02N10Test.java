package week2;

import static util.Assert.assertEquals;
import static week2.TaskT02N10.isNumberEndsWithEven;

public class TaskT02N10Test {
    public static void main(String[] args) {
        testIfZero();
        testIfPositiveInteger();
        testIfPositiveDouble();
        testIfNegativeInteger();
        testIfNegativeDouble();
    }

    public static void testIfZero() {
        assertEquals("Week2.TaskT02N10Test.testIfZero", true, isNumberEndsWithEven(0));
    }

    public static void testIfNegativeInteger() {
        assertEquals("Week2.TaskT02N10Test.testIfNegativeInteger", false, isNumberEndsWithEven(-9));
    }

    public static void testIfNegativeDouble() {
        assertEquals("Week2.TaskT02N10Test.testIfNegativeDouble", true, isNumberEndsWithEven(-10.98));
    }

    public static void testIfPositiveInteger() {
        assertEquals("Week2.TaskT02N10Test.testIfPositiveInteger", false, isNumberEndsWithEven(7653));
    }

    public static void testIfPositiveDouble() {
        assertEquals("Week2.TaskT02N10Test.testIfPositiveDouble", true, isNumberEndsWithEven(709.34));
    }
}
