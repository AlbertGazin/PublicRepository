package week2;

import static util.Assert.assertEquals;
import static week2.TaskT02N17.getMetersToHome;
import static week2.TaskT02N17.getSumMeters;

public class TaskT02N17Test {
    public static void main(String[] args) {
        testMetersToHome();
        testSumMeters();
    }

    public static void testSumMeters() {
        assertEquals("Week2.TaskT02N17Test.testSumMeters", 5187.37751763962, getSumMeters());
    }

    public static void testMetersToHome() {
        assertEquals("Week2.TaskT02N17Test.testMetersToHome", 688.1721793101949, getMetersToHome());
    }
}
