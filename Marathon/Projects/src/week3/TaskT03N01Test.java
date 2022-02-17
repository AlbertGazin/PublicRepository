package week3;

import static util.Assert.assertEquals;
import static week3.TaskT03N01.getSymbolOfString;

public class TaskT03N01Test {
    public static void main(String[] args) {
        testEmptyWordSubstrMethod();
        testEmptyWordCharAtMethod();
        testIncorrectIndexCharAtMethod();
        testIncorrectIndexSubstrMethod();
        testWordCharAtMethod();
        testWordSubstrMethod();
    }

    public static void testEmptyWordSubstrMethod() {
        assertEquals(
                "Week3.TaskT03N01Test.testEmptyWordSubstrMethod", "Word is empty",
                getSymbolOfString("", 9, "Substring"));
    }

    public static void testEmptyWordCharAtMethod() {
        assertEquals(
                "Week3.TaskT03N01Test.testEmptyWordCharAtMethod", "Word is empty",
                getSymbolOfString("", 9, ""));
    }

    public static void testIncorrectIndexSubstrMethod() {
        assertEquals(
                "Week3.TaskT03N01Test.testIncorrectIndexSubstrMethod", "Index should be correct",
                getSymbolOfString("Test", 9, "Substring"));
    }

    public static void testIncorrectIndexCharAtMethod() {
        assertEquals(
                "Week3.TaskT03N01Test.testIncorrectIndexCharAtMethod", "Index should be correct",
                getSymbolOfString("Test", 9, ""));
    }

    public static void testWordSubstrMethod() {
        assertEquals(
                "Week3.TaskT03N01Test.testWordSubstrMethod", "e",
                getSymbolOfString("Test", 1, "Substring"));
    }

    public static void testWordCharAtMethod() {
        assertEquals(
                "Week3.TaskT03N01Test.testWordCharAtMethod", "e",
                getSymbolOfString("Test", 1, "testWordCharAtMethod"));
    }
}
