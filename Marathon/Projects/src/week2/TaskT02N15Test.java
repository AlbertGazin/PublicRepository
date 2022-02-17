package week2;

import static util.Assert.assertEquals;
import static week2.TaskT02N15.getArrayChangeUsdToRub;

public class TaskT02N15Test {
    public static void main(String[] args) {
        test65();
        testZero();
    }

    public static void test65() {
        double[] expected = {65.0, 130.0, 195.0, 260.0, 325.0, 390.0, 455.0, 520.0, 585.0, 650.0, 715.0, 780.0, 845.0, 910.0, 975.0, 1040.0, 1105.0, 1170.0, 1235.0, 1300.0};
        assertEquals("Week2.TaskT02N15Test.test65", expected, getArrayChangeUsdToRub(65));
    }

    public static void testZero() {
        double[] expected = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        assertEquals("Week2.TaskT02N15Test.testZero", expected, getArrayChangeUsdToRub(0));
    }
}
