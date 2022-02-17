package week1;

import static util.Assert.assertEquals;
import static week1.TaskT01N08.printUserNumber;

public class TaskT01N08Test {
    public static void main(String[] args) {
        testPositiveNumber();
        testNegativeNumber();
        testWord();
    }

    public static void testPositiveNumber() {
        assertEquals("Week1.TaskT01N08Test.testPositiveNumber", "Вы ввели число 48.9", printUserNumber("48.9"));
    }

    public static void testNegativeNumber() {
        assertEquals("Week1.TaskT01N08Test.testNegativeNumber", "Вы ввели число -48", printUserNumber("-48"));
    }

    public static void testWord() {
        assertEquals("Week1.TaskT01N08Test.testWord", "Вы ввели не число", printUserNumber("48j"));
    }
}
