package week2;

import static util.Assert.assertEquals;
import static week2.TaskT02N06.factorial;

public class TaskT02N06Test {
    public static void main(String[] args) {
        testFactorial0();
        testFactorial1();
        testFactorial2();
        testFactorial3();
        testFactorial5();
    }

    public static void testFactorial0() {
        assertEquals("Week2.TaskT02N06Test.testFactorial0", 1, factorial(0));
    }

    public static void testFactorial1() {
        assertEquals("Week2.TaskT02N06Test.testFactorial1", 1, factorial(1));
    }

    public static void testFactorial2() {
        assertEquals("Week2.TaskT02N06Test.testFactorial2", 2, factorial(2));
    }

    public static void testFactorial3() {
        assertEquals("Week2.TaskT02N06Test.testFactorial3", 6, factorial(3));
    }

    public static void testFactorial5() {
        assertEquals("Week2.TaskT02N06Test.testFactorial5", 120, factorial(5));
    }
}
