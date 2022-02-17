package week1;

import static util.Assert.assertEquals;
import static week1.TaskT01N14.*;

public class TaskT01N14Test {
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
        test1Task7();
        test2Task7();
        test1Task8();
        test2Task8();
        test1Task9();
        test2Task9();
    }

    public static void test1Task1() {
        assertEquals("Week1.TaskT01N14Test.test1Task1", true, task1(3, 4));
    }

    public static void test2Task1() {
        assertEquals("Week1.TaskT01N14Test.test2Task1", false, task1(1, 4));
    }

    public static void test1Task2() {
        assertEquals("Week1.TaskT01N14Test.test1Task2", true, task2(3, 4));
    }

    public static void test2Task2() {
        assertEquals("Week1.TaskT01N14Test.test2Task2", false, task2(1, -5));
    }

    public static void test1Task3() {
        assertEquals("Week1.TaskT01N14Test.test1Task3", true, task3(3, 4));
    }

    public static void test2Task3() {
        assertEquals("Week1.TaskT01N14Test.test2Task3", false, task3(1, 6));
    }

    public static void test1Task4() {
        assertEquals("Week1.TaskT01N14Test.test1Task4", true, task4(3));
    }

    public static void test2Task4() {
        assertEquals("Week1.TaskT01N14Test.test2Task4", false, task4(2));
    }

    public static void test1Task5() {
        assertEquals("Week1.TaskT01N14Test.test1Task5", true, task5(5));
    }

    public static void test2Task5() {
        assertEquals("Week1.TaskT01N14Test.test2Task5", false, task5(1));
    }

    public static void test1Task6() {
        assertEquals("Week1.TaskT01N14Test.test1Task6", true, task6(1));
    }

    public static void test2Task6() {
        assertEquals("Week1.TaskT01N14Test.test2Task6", false, task6(5));
    }

    public static void test1Task7() {
        assertEquals("Week1.TaskT01N14Test.test1Task7", true, task7(8));
    }

    public static void test2Task7() {
        assertEquals("Week1.TaskT01N14Test.test2Task7", false, task7(1));
    }

    public static void test1Task8() {
        assertEquals("Week1.TaskT01N14Test.test1Task8", true, task8(12));
    }

    public static void test2Task8() {
        assertEquals("Week1.TaskT01N14Test.test2Task8", false, task8(26));
    }

    public static void test1Task9() {
        assertEquals("Week1.TaskT01N14Test.test1Task9", true, task9(3, 3));
    }

    public static void test2Task9() {
        assertEquals("Week1.TaskT01N14Test.test2Task9", false, task9(26, 11));
    }
}
