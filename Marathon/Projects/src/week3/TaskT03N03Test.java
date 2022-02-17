package week3;

import static util.Assert.assertEquals;
import static week3.TaskT03N03.halfOfString;

public class TaskT03N03Test {
    public static void main(String[] args) {
        testEmptyString();
        testStringWithOddCountOfWords();
        testCorrectString();
    }

    public static void testEmptyString() {
        assertEquals(
                "Week3.TaskT03N03Test.testEmptyString", "String is empty !", halfOfString(""));
    }

    public static void testStringWithOddCountOfWords() {
        assertEquals(
                "Week3.TaskT03N03Test.testStringWithOddCountOfWords", "Count of words in string is not even !",
                halfOfString("Testing"));
    }

    public static void testCorrectString() {
        assertEquals(
                "Week3.TaskT03N03Test.testCorrectString", "Test", halfOfString("TestTest"));
    }
}