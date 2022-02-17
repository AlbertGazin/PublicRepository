package week2;

import static util.Assert.assertEquals;
import static week2.TaskT02N03.getMaxFromArray;

public class TaskT02N03Test {
    public static void main(String[] args) {
        testGetMaxFromPositiveNumbers();
        testGetMaxFromNegativeNumbers();
        testGetMaxFromAllZero();
        testGetMaxFromDifferentNumbers();
    }

    public static void testGetMaxFromPositiveNumbers() {
        double[] k = {3, 50, 7, 49};
        assertEquals("Week2.TaskT02N03Test.testGetMaxFromPositiveNumbers", 50, getMaxFromArray(k));
    }

    public static void testGetMaxFromNegativeNumbers() {
        double[] k = {-3, -50, -7, -49};
        assertEquals("Week2.TaskT02N03Test.testGetMaxFromNegativeNumbers", -3, getMaxFromArray(k));
    }

    public static void testGetMaxFromAllZero() {
        double[] k = {0, 0, 0, 0};
        assertEquals("Week2.TaskT02N03Test.testGetMaxFromAllZero", 0, getMaxFromArray(k));
    }

    public static void testGetMaxFromDifferentNumbers() {
        double[] k = {0, -50, 40, 90087, -1000, 500.856};
        assertEquals("Week2.TaskT02N03Test.testGetMaxFromDifferentNumbers", 90087, getMaxFromArray(k));
    }
}
