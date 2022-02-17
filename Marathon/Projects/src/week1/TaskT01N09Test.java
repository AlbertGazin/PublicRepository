package week1;

import static util.Assert.assertEquals;
import static week1.TaskT01N09.task5;

public class TaskT01N09Test {
    public static void main(String[] args) {
        testTask5();
        testTask5IfNegative();
    }

    public static void testTask5() {
        assertEquals("Week1.TaskT01N09Test.testTask5", 3, task5(1));
    }

    public static void testTask5IfNegative() {
        assertEquals("Week1.TaskT01N09Test.testTask5IfNegative", 3, task5(-2));
    }
}
