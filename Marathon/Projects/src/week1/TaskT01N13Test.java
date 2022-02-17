package week1;

import static util.Assert.assertEquals;
import static week1.TaskT01N13.checkNaturalNumbers;

public class TaskT01N13Test {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {

        assertEquals("Week1.Task01N13Test.test1", 1.0, checkNaturalNumbers(5, 20));
    }

    public static void test2() {

        assertEquals("Week1.Task01N13Test.test2", 1.0, checkNaturalNumbers(10, 2));
    }

    public static void test3() {

        assertEquals("Week1.Task01N13Test.test3", 7.0, checkNaturalNumbers(5, 3));
    }

    public static void test4() {

        assertEquals("Week1.Task01N13Test.test4", 22.0, checkNaturalNumbers(7, 17));
    }
}
