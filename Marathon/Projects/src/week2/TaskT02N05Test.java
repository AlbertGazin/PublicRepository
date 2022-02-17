package week2;

import static util.Assert.assertEquals;
import static week2.TaskT02N05.getCountOfDigitsInNumber;

public class TaskT02N05Test {
    public static void main(String[] args) {
        test1234();
        test888888();
        testIfNumberIsZero();
        testIfNumberIsNegative();
    }

    public static void testIfNumberIsZero() {
        assertEquals("Week2.TaskT02N05Test.testIfNumberIsZero", 1, getCountOfDigitsInNumber(0));
    }

    public static void test1234() {
        assertEquals("Week2.TaskT02N05Test.test1234", 4, getCountOfDigitsInNumber(1234));
    }

    public static void test888888() {
        assertEquals("Week2.TaskT02N05Test.test888888", 6, getCountOfDigitsInNumber(888888));
    }

    public static void testIfNumberIsNegative() {
        assertEquals("Week2.TaskT02N05Test.testIfNumberIsNegative", -1, getCountOfDigitsInNumber(-7632));
    }
}
