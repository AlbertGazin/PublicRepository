package week3;

import static util.Assert.assertEquals;
import static week3.TaskT03N06.lastValueFromCsv;

public class TaskT03N06Test {
    public static void main(String[] args) {
        testEmptyString();
        testStringDoesntContainSemicolon();
        testStringOne();
        testStringTwo();
        testStringThree();
        testStringFour();
    }

    public static void testEmptyString() {
        assertEquals(
                "Week3.TaskT03N06Test.testEmptyString", "String is empty !",
                lastValueFromCsv(""));
    }

    public static void testStringDoesntContainSemicolon() {
        assertEquals(
                "Week3.TaskT03N06Test.testStringDoesntContainSemicolon", "String does not contain ';'",
                lastValueFromCsv("Testing"));
    }

    public static void testStringOne() {
        assertEquals(
                "Week3.TaskT03N06Test.testStringOne", "Testing",
                lastValueFromCsv("Testing;"));
    }

    public static void testStringTwo() {
        assertEquals(
                "Week3.TaskT03N06Test.testStringTwo", "test",
                lastValueFromCsv("Testing;test"));
    }

    public static void testStringThree() {
        assertEquals(
                "Week3.TaskT03N06Test.testStringThree", "test",
                lastValueFromCsv("Testing;test;"));
    }

    public static void testStringFour() {
        assertEquals(
                "Week3.TaskT03N06Test.testStringFour", "test",
                lastValueFromCsv("Testing;test;;"));
    }
}
