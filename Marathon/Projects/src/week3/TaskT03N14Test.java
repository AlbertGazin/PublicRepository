package week3;

import static util.Assert.assertEquals;
import static week3.TaskT03N14.sortArrayAlphabet;

public class TaskT03N14Test {
    public static void main(String[] args) {
        testEmptyArray();
        testArrayOfOneWord();
        testArrayOfWordsInUpperCase();
        testArrayOfWordsInLowerCase();
        testArrayOfWordsInDiffCase();
        testArrayWithEmptyWord();
    }

    public static void testEmptyArray() {
        String[] m = {};
        assertEquals("Week3.TaskT03N14Test.testEmptyArray", m, sortArrayAlphabet(m));
    }

    public static void testArrayOfOneWord() {
        String[] m = {"global"};
        assertEquals("Week3.TaskT03N14Test.testArrayOfOneWord", m, sortArrayAlphabet(m));
    }

    public static void testArrayOfWordsInUpperCase() {
        String[] array = {"GLOBAL", "ALPHA", "MARKETING", "BALL"};
        String[] expected = {"ALPHA", "BALL", "GLOBAL", "MARKETING"};
        assertEquals("Week3.TaskT03N14Test.testArrayOfWordsInUpperCase", expected, sortArrayAlphabet(array));
    }

    public static void testArrayOfWordsInLowerCase() {
        String[] array = {"zip", "alpha", "marketing", "ball"};
        String[] expected = {"alpha", "ball", "marketing", "zip"};
        assertEquals("Week3.TaskT03N14Test.testArrayOfWordsInLowerCase", expected, sortArrayAlphabet(array));
    }

    public static void testArrayOfWordsInDiffCase() {
        String[] array = {"zip", "Alpha", "MarKeting", "ball", "NAIL"};
        String[] expected = {"Alpha", "ball", "MarKeting", "NAIL", "zip"};
        assertEquals("Week3.TaskT03N14Test.testArrayOfWordsInDiffCase", expected, sortArrayAlphabet(array));
    }

    public static void testArrayWithEmptyWord() {
        String[] array = {"GLOBAL", "ALPHA", "MARKETING", "BALL", ""};
        String[] expected = {"There are empty words in your array!"};
        assertEquals("Week3.TaskT03N14Test.testArrayWithEmptyWord", expected, sortArrayAlphabet(array));
    }
}
