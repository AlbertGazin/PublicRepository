package week3;

import static util.Assert.assertEquals;
import static week3.TaskT03N02.isBeginCharEqualsEndChar;

public class TaskT03N02Test {
    public static void main(String[] args) {
        testEmptyStringCharAtMethod();
        testEmptyStringSubstrMethod();
        testLowerCharAtMethod();
        testLowerSubstrMethod();
        testCamelCaseCharAtMethod();
        testCamelCaseSubstrMethod();
        testDiffWordsCharAtMethod();
        testDiffWordsSubstrMethod();
        testStringWithDigitsCharAtMethod();
        testStringWithDigitsSubstrMethod();
        testOneLowerWordCharAtMethod();
        testOneLowerWordSubstrMethod();
        testOneUpperWordCharAtMethod();
        testOneUpperWordSubstrMethod();
        testUpperCharAtMethod();
        testUpperSubstrMethod();
    }

    public static void testEmptyStringSubstrMethod() {
        assertEquals(
                "Week3.TaskT03N02Test.testEmptyStringSubstrMethod", false,
                isBeginCharEqualsEndChar("", "Substring"));
    }

    public static void testEmptyStringCharAtMethod() {
        assertEquals(
                "Week3.TaskT03N02Test.testEmptyStringCharAtMethod", false,
                isBeginCharEqualsEndChar("", ""));
    }

    public static void testUpperSubstrMethod() {
        assertEquals(
                "Week3.TaskT03N02Test.testUpperSubstrMethod", true,
                isBeginCharEqualsEndChar("TEST", "Substring"));
    }

    public static void testUpperCharAtMethod() {
        assertEquals("Week3.TaskT03N02Test.testUpperCharAtMethod", true,
                isBeginCharEqualsEndChar("TEST", ""));
    }

    public static void testLowerSubstrMethod() {
        assertEquals(
                "Week3.TaskT03N02Test.testLowerSubstrMethod", true,
                isBeginCharEqualsEndChar("test", "Substring"));
    }

    public static void testLowerCharAtMethod() {
        assertEquals("Week3.TaskT03N02Test.testLowerCharAtMethod", true,
                isBeginCharEqualsEndChar("test", ""));
    }

    public static void testCamelCaseSubstrMethod() {
        assertEquals(
                "Week3.TaskT03N02Test.testCamelCaseSubstrMethod", true,
                isBeginCharEqualsEndChar("TeSt", "Substring"));
    }

    public static void testCamelCaseCharAtMethod() {
        assertEquals(
                "Week3.TaskT03N02Test.testCamelCaseCharAtMethod", true,
                isBeginCharEqualsEndChar("TeSt", ""));
    }

    public static void testOneUpperWordSubstrMethod() {
        assertEquals(
                "Week3.TaskT03N02Test.testOneUpperWordSubstrMethod", true,
                isBeginCharEqualsEndChar("T", "Substring"));
    }

    public static void testOneUpperWordCharAtMethod() {
        assertEquals("Week3.TaskT03N02Test.testOneUpperWordCharAtMethod", true,
                isBeginCharEqualsEndChar("T", ""));
    }

    public static void testOneLowerWordSubstrMethod() {
        assertEquals(
                "Week3.TaskT03N02Test.testOneLowerWordSubstrMethod", true,
                isBeginCharEqualsEndChar("t", "Substring"));
    }

    public static void testOneLowerWordCharAtMethod() {
        assertEquals("Week3.TaskT03N02Test.testOneLowerWordCharAtMethod", true,
                isBeginCharEqualsEndChar("t", ""));
    }

    public static void testDiffWordsSubstrMethod() {
        assertEquals(
                "Week3.TaskT03N02Test.testDiffWordsSubstrMethod", false,
                isBeginCharEqualsEndChar("Test1", "Substring"));
    }

    public static void testDiffWordsCharAtMethod() {
        assertEquals(
                "Week3.TaskT03N02Test.testDiffWordsCharAtMethod", false,
                isBeginCharEqualsEndChar("Test1", ""));
    }

    public static void testStringWithDigitsSubstrMethod() {
        assertEquals(
                "Week3.TaskT03N02Test.testStringWithDigitsSubstrMethod", false,
                isBeginCharEqualsEndChar("123", "Substring"));
    }

    public static void testStringWithDigitsCharAtMethod() {
        assertEquals(
                "Week3.TaskT03N02Test.testStringWithDigitsCharAtMethod", false,
                isBeginCharEqualsEndChar("123", ""));
    }
}
