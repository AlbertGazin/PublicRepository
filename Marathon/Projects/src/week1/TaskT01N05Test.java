package week1;

import static util.Assert.assertEquals;
import static week1.TaskT01N05.*;

public class TaskT01N05Test {
    public static void main(String[] args) {
        testOneUsdExch();
        testNegativeUsdCount();
        testNegativeCourse();
        testDoubleTypeOfCorse();
    }

    public static void testOneUsdExch() {
        assertEquals("Week1.TaskT01N05Test.testOneUsdExch", 10, convertUsdToBtc(1, 10));
    }

    public static void testNegativeUsdCount() {
        assertEquals("Week1.TaskT01N05Test.testNegativeUsdCount", -1, convertUsdToBtc(-1, 10));
    }

    public static void testNegativeCourse() {
        assertEquals("Week1.TaskT01N05Test.testNegativeCourse", -1, convertUsdToBtc(1, -10));
    }

    public static void testDoubleTypeOfCorse() {
        assertEquals("Week1.TaskT01N05Test.testDoubleTypeOfCourse", 55.05, convertUsdToBtc(10, 5.505));
    }
}
