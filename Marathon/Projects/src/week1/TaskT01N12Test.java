package week1;

import static util.Assert.assertEquals;
import static week1.TaskT01N12.getAngleValue;

public class TaskT01N12Test {
    public static void main(String[] args) {
        testOneHour();
        testOneHourTwoDigits();
        testHourLessThanZero();
        testMinuteLessThanZero();
        testSecondsLessThanZero();
        testHourMoreThan23();
        testMinuteMoreThan59();
        testSecondMoreThan59();
        testSixHours();
        testSixHoursTwoDigits();
        testThreeHours();
        testThreeHoursTwoDigits();
    }

    public static void testOneHour() {
        assertEquals("Week1.TaskT01N12Test.testOneHour", 30.0, getAngleValue(1, 0, 0));
    }

    public static void testOneHourTwoDigits() {
        assertEquals("Week1.TaskT01N12Test.testOneHourTwoDigits", 30.0, getAngleValue(13, 0, 0));
    }

    public static void testHourMoreThan23() {
        assertEquals("Week1.TaskT01N12Test.testHourMoreThan23", -1.0, getAngleValue(24, 0, 0));
    }

    public static void testMinuteMoreThan59() {
        assertEquals("Week1.TaskT01N12Test.testMinuteMoreThan60", -1.0, getAngleValue(5, 62, 0));
    }

    public static void testSecondMoreThan59() {
        assertEquals("Week1.TaskT01N12Test.testSecondMoreThan59", -1.0, getAngleValue(4, 0, 65));
    }

    public static void testSixHours() {
        assertEquals("Week1.TaskT01N12Test.testSixHours", 180.0, getAngleValue(6, 0, 0));
    }

    public static void testSixHoursTwoDigits() {
        assertEquals("Week1.TaskT01N12Test.testSixHoursTwoDigits", 180.0, getAngleValue(18, 0, 0));
    }

    public static void testThreeHours() {
        assertEquals("Week1.TaskT01N12Test.testThreeHours", 90.0, getAngleValue(3, 0, 0));
    }

    public static void testThreeHoursTwoDigits() {
        assertEquals("Week1.TaskT01N12Test.testThreeHoursTwoDigits", 90.0, getAngleValue(15, 0, 0));
    }

    public static void testHourLessThanZero() {
        assertEquals("Week1.TaskT01N12Test.testHourLessThanZero", -1.0, getAngleValue(-6, 0, 0));
    }

    public static void testMinuteLessThanZero() {
        assertEquals("Week1.TaskT01N12Test.testMinuteLessThanZero", -1.0, getAngleValue(5, -4, 0));
    }

    public static void testSecondsLessThanZero() {
        assertEquals("Week1.TaskT01N12Test.testSecondsLessThanZero", -1.0, getAngleValue(7, 0, -5));
    }
}
