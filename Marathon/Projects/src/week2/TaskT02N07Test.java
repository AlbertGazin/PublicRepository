package week2;

import static util.Assert.assertEquals;
import static week2.TaskT02N07.getNameOfDay;

public class TaskT02N07Test {
    public static void main(String[] args) {
        testDay1();
        testDay6();
        testIncorrectDay();
    }

    public static void testDay1() {
        assertEquals("Week2.TaskT02N07Test.testDay1", "Понедельник", getNameOfDay(1));
    }

    public static void testDay6() {
        assertEquals("Week2.TaskT02N07Test.testDay6", "Суббота", getNameOfDay(6));
    }

    public static void testIncorrectDay() {
        assertEquals("Week2.TaskT02N07Test.testIncorrectDay", "Некорректно", getNameOfDay(10));
    }
}
