package week2;

import static util.Assert.assertEquals;
import static week2.TaskT02N12.getAgeOfPerson;

public class TaskT02N12Test {
    public static void main(String[] args) {
        testEqualYears();
        testEqualMonths();
        testEqualMonthsAndYears();
        testBirthMonthsLessThanCurrentMonth();
        testBirthMonthsMoreThanCurrentMonth();
    }

    public static void testEqualYears() {
        assertEquals("Week2.TaskT02N12Test.testEqualYears", 1, getAgeOfPerson(1985, 5, 1985, 7));
    }

    public static void testEqualMonths() {
        assertEquals("Week2.TaskT02N12Test.testEqualMonths", 35, getAgeOfPerson(1985, 5, 2020, 5));
    }

    public static void testEqualMonthsAndYears() {
        assertEquals("Week2.TaskT02N12Test.testEqualMonthsAndYears", 1, getAgeOfPerson(1985, 5, 1985, 5));
    }

    public static void testBirthMonthsLessThanCurrentMonth() {
        assertEquals("Week2.TaskT02N12Test.testBirthMonthsLessThanCurrentMonth", 35, getAgeOfPerson(1985, 5, 2020, 7));
    }

    public static void testBirthMonthsMoreThanCurrentMonth() {
        assertEquals("Week2.TaskT02N12Test.testBirthMonthsMoreThanCurrentMonth", 34, getAgeOfPerson(1985, 5, 2020, 3));
    }
}
