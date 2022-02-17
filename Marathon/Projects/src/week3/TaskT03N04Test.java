package week3;

import static util.Assert.assertEquals;
import static week3.TaskT03N04.isWordPalindrome;

public class TaskT03N04Test {
    public static void main(String[] args) {
        testEmptyString();
        testStringOne();
        testStringTwo();
        testStringThree();
        testStringFour();
        testStringFive();
    }

    public static void testEmptyString() {
        assertEquals("Week3.TaskT03N04Test.testEmptyWord", false, isWordPalindrome(""));
    }

    public static void testStringOne() {
        assertEquals("Week3.TaskT03N04Test.testStringOne", false, isWordPalindrome("Test"));
    }

    public static void testStringTwo() {
        assertEquals("Week3.TaskT03N04Test.testStringTwo", true, isWordPalindrome("Abba"));
    }

    public static void testStringThree() {
        assertEquals("Week3.TaskT03N04Test.testStringThree", true, isWordPalindrome("SOS"));
    }

    public static void testStringFour() {
        assertEquals("Week3.TaskT03N04Test.testStringFour", true, isWordPalindrome("mAdaM"));
    }

    public static void testStringFive() {
        assertEquals("Week3.TaskT03N04Test.testStringFive", true, isWordPalindrome("123321"));
    }
}
