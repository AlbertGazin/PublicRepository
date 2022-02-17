package week3;

import static util.Assert.assertEquals;
import static week3.TaskT03N07.changeFirstAndLastWordsInSentence;

public class TaskT03N07Test {
    public static void main(String[] args) {
        testEmptyString();
        testStringOfSpaces();
        testStringOfOneWord();
        testStringOfOneWordAndSpaces();
        testCorrectString();
    }

    public static void testEmptyString() {
        assertEquals("Week3.TaskT03N07Test.testEmptyString", "String is empty !",
                changeFirstAndLastWordsInSentence(""));
    }

    public static void testStringOfSpaces() {
        assertEquals("Week3.TaskT03N07Test.testStringOfSpaces", "String is empty !",
                changeFirstAndLastWordsInSentence("   "));
    }

    public static void testStringOfOneWord() {
        assertEquals("Week3.TaskT03N07Test.testStringOfOneWord", "Test ",
                changeFirstAndLastWordsInSentence("Test"));
    }

    public static void testStringOfOneWordAndSpaces() {
        assertEquals("Week3.TaskT03N07Test.testStringOfOneWordAndSpaces", "Test ",
                changeFirstAndLastWordsInSentence("Test   "));
    }

    public static void testCorrectString() {
        assertEquals("Week3.TaskT03N07Test.testCorrectString", "done   is   Test ",
                changeFirstAndLastWordsInSentence("Test   is   done  "));
    }
}
