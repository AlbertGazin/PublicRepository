package week2;

import static util.Assert.assertEquals;
import static week2.TaskT02N11.getInfoAboutDay;

public class TaskT02N11Test {
    public static void main(String[] args) {
        testDay1();
        testDay14();
        testDay41();
        testDay356();
        testDay410();
    }

    public static void testDay1() {
        assertEquals("Week2.TaskT02N11Test.testDay1", "Workday", getInfoAboutDay(1));
    }

    public static void testDay14() {
        assertEquals("Week2.TaskT02N11Test.testDay14", "Weekend", getInfoAboutDay(14));
    }

    public static void testDay41() {
        assertEquals("Week2.TaskT02N11Test.testDay41", "Weekend", getInfoAboutDay(41));
    }

    public static void testDay356() {
        assertEquals("Week2.TaskT02N11Test.testDay41", "Workday", getInfoAboutDay(365));
    }

    public static void testDay410() {
        assertEquals("Week2.TaskT02N11Test.testDay410", "Day should be between 1 and 365", getInfoAboutDay(410));
    }
}
