package week1;

import static util.Assert.assertEquals;
import static week1.TaskT01N04.secondCount;

public class TaskT01N04Test {
    public static void main(String[] args) {
        testOneHour();
        testTenHour();
    }

    public static void testOneHour() {
        assertEquals("Week1.TaskT01N04Test.testOneHour", 3600, secondCount(1));
    }

    public static void testTenHour() {
        assertEquals("Week1.TaskT01N04Test.testTenHour", 36000, secondCount(10));
    }
}
