package week3;

import static util.Assert.assertEquals;
import static week3.TaskT03N10.myName;

public class TaskT03N10Test {
    public static void main(String[] args) {
        testMyName();
    }

    public static void testMyName() {
        assertEquals("Week3.TaskT03N10Test.testMyName", "Albert", myName());
    }
}
