package week1;

import static util.Assert.assertEquals;
import static week1.TaskT01N15.*;

public class TaskT01N15Test {
    public static void main(String[] args) {
        test1Task1();
        test2Task1();
        test1Task2();
        test2Task2();
        test1Task3();
        test2Task3();
        test1Task4();
        test2Task4();
        test1Task5();
        test2Task5();
        test1Task6();
        test2Task6();
    }

    public static void test1Task1() {
        assertEquals("Week1.TaskT01N15Test.test1Task1", false, task1(1, 6));
    }

    public static void test2Task1() {
        assertEquals("Week1.TaskT01N15Test.test2Task1", true, task1(1, 3));
    }

    public static void test1Task2() {
        assertEquals("Week1.TaskT01N15Test.test1Task2", true, task2(1, 26));
    }

    public static void test2Task2() {
        assertEquals("Week1.TaskT01N15Test.test2Task2", false, task2(20, 20));
    }

    public static void test1Task3() {
        assertEquals("Week1.TaskT01N15Test.test1Task3", false, task3(1, 6));
    }

    public static void test2Task3() {
        assertEquals("Week1.TaskT01N15Test.test2Task3", true, task3(0, 3));
    }

    public static void test1Task4() {
        assertEquals("Week1.TaskT01N15Test.test1Task4", false, task4(1, 6, 7));
    }

    public static void test2Task4() {
        assertEquals("Week1.TaskT01N15Test.test2Task4", true, task4(-1, -3, -7));
    }

    public static void test1Task5() {
        assertEquals("Week1.TaskT01N15Test.test1Task5", false, task5(1, 6, 7));
    }

    public static void test2Task5() {
        assertEquals("Week1.TaskT01N15Test.test2Task5", true, task5(20, 3, 7));
    }

    public static void test1Task6() {
        assertEquals("Week1.TaskT01N15Test.test1Task6", false, task6(1, 6, 7));
    }

    public static void test2Task6() {
        assertEquals("Week1.TaskT01N15Test.test2Task6", true, task6(104, 308, 709));
    }
}
