package week2;

import static util.Assert.assertEquals;
import static week2.TaskT02N08.getDigitalRoot;

public class TaskT02N08Test {
    public static void main(String[] args) {
        testSum999();
        testSum0();
        testSum7();
        testSum10();
        testSum785();
        testSumMinus832();
    }

    public static void testSum999() {
        assertEquals("Week2.TaskT02N08Test.testSum999", 9, getDigitalRoot(999));
    }

    public static void testSum10() {
        assertEquals("Week2.TaskT02N08Test.testSum10", 1, getDigitalRoot(10));
    }

    public static void testSum7() {
        assertEquals("Week2.TaskT02N08Test.testSum7", 7, getDigitalRoot(7));
    }

    public static void testSum785() {
        assertEquals("Week2.TaskT02N08Test.testSum785", 2, getDigitalRoot(785));
    }

    public static void testSum0() {
        assertEquals("Week2.TaskT02N08Test.testSum0", 0, getDigitalRoot(0));
    }

    public static void testSumMinus832() {
        assertEquals("Week2.TaskT02N08Test.testSumMinus832", -4, getDigitalRoot(-832));
    }
}
