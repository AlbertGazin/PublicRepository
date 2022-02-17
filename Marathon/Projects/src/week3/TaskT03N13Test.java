package week3;

import static util.Assert.assertEquals;
import static week3.TaskT03N13.putUpperFirstWordsOfText;

public class TaskT03N13Test {
    public static void main(String[] args) {
        testEmptyText();
        testOneWord();
        testTwoWords();
        testWordsAndSpaces();
        testText();
    }

    public static void testEmptyText() {
        assertEquals("Week3.TaskT03N13Test.testEmptyText", "Text is empty !",
                putUpperFirstWordsOfText(""));
    }

    public static void testOneWord() {
        assertEquals("Week3.TaskT03N13Test.testOneWord", "A",
                putUpperFirstWordsOfText("a"));
    }

    public static void testTwoWords() {
        assertEquals("Week3.TaskT03N13Test.testTwoWords", "Ab",
                putUpperFirstWordsOfText("ab"));
    }

    public static void testWordsAndSpaces() {
        assertEquals("Week3.TaskT03N13Test.testWordsAndSpaces", "Ab F Ty, Eee M",
                putUpperFirstWordsOfText("Ab f ty, eee m"));
    }

    public static void testText() {
        assertEquals("Week3.TaskT03N13Test.testText",
                "Hi!!! What Are You Doing?? I Want To Watch A Film))) What About Go To The CInEmA???!!",
                putUpperFirstWordsOfText(
                        "hi!!! what are you doing?? i want to watch a film))) what about go to the cInEmA???!!"));
    }
}
