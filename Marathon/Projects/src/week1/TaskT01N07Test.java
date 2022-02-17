package week1;

import static util.Assert.assertEquals;
import static week1.TaskT01N07.Pi;

public class TaskT01N07Test {
    public static void main(String[] args) {
        testCheckPi();
    }

    public static void testCheckPi() {
        assertEquals("Week1.TaskT01N07Test.testCheckPi", "3.14", Pi());
    }
}
