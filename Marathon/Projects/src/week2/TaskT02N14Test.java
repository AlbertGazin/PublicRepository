package week2;

import static util.Assert.assertEquals;
import static week2.TaskT02N14.getSeason;

public class TaskT02N14Test {
    public static void main(String[] args) {
        testSpring();
        testSummer();
        testAutumn();
        testWinter();
        testIncorrectMonth();
    }

    public static void testSummer() {
        assertEquals("Week2.TestT02N14Test.testSummer", "Лето", getSeason(6));
    }

    public static void testWinter() {
        assertEquals("Week2.TestT02N14Test.testWinter", "Зима", getSeason(1));
    }

    public static void testAutumn() {
        assertEquals("Week2.TestT02N14Test.testAutumn", "Осень", getSeason(10));
    }

    public static void testSpring() {
        assertEquals("Week2.TestT02N14Test.testSpring", "Весна", getSeason(4));
    }

    public static void testIncorrectMonth() {
        assertEquals("Week2.TestT02N14Test.testIncorrectMonth", "Номер месяца должен быть в диапазоне от 1 до 12", getSeason(62));
    }
}
