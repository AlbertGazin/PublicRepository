package week1;

import static util.Assert.assertEquals;
import static week1.TaskT01N11.findOriginalNumber;

public class TaskT01N11Test {
    public static void main(String[] args) {
        test808();
        test700();
        test999();
        testNumberLessThan100();
        testNumberMoreThan999();
    }

    public static void testNumberMoreThan999() {
        assertEquals("Week1.TaskT01N11.testNumberMoreThan999", -1, findOriginalNumber(1234));
    }

    public static void testNumberLessThan100() {
        assertEquals("Week1.TaskT01N11.testNumberLessThan100", -1, findOriginalNumber(12));
    }

    public static void test700() {
        assertEquals("Week1.TaskT01N11.test700", 700, findOriginalNumber(700));
    }

    public static void test999() {
        assertEquals("Week1.TaskT01N11.test999", 999, findOriginalNumber(999));
    }

    public static void test808() {
        assertEquals("Week1.TaskT01N11.test808", 880, findOriginalNumber(808));
    }
}
