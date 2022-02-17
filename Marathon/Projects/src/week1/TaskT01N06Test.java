package week1;

import static util.Assert.assertEquals;
import static week1.TaskT01N06.getSum;

public class TaskT01N06Test {
    public static void main(String[] args) {
        testNegativeBeginSum();
        testNegativePercent();
        testNegativeMonthCount();
    }

    public static void testNegativePercent() {
        assertEquals("Week1.TaskT01N06Test.testNegativePercent", -1, getSum(100, -5, 12));
    }

    public static void testNegativeBeginSum() {
        assertEquals("Week1.TaskT01N06Test.testNegativeBeginSum", -1, getSum(-100, 5, 12));
    }

    public static void testNegativeMonthCount() {
        assertEquals("Week1.TaskT01N06Test.testNegativeMonthCount", -1, getSum(100, 5, -12));
    }
}
