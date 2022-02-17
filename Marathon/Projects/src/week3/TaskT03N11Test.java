package week3;

import static util.Assert.assertEquals;
import static week3.TaskT03N11.changeSentence;

public class TaskT03N11Test {
    public static void main(String[] args) {
        testEmptySentence();
        testSentenceWithoutWords();
        testSentence();
    }

    public static void testEmptySentence() {
        assertEquals("Week3.TaskT03N11Test.testEmptySentence", "", changeSentence(""));
    }

    public static void testSentenceWithoutWords() {
        assertEquals("Week3.TaskT03N11Test.testSentenceWithoutWords", "", changeSentence("!?,.-)"));
    }

    public static void testSentence() {
        assertEquals("Week3.TaskT03N11Test.testSentence",
                "HELLO ALBERT HOW ARE YOU  ЧЕМ ЗАНЯТ  ",
                changeSentence("!!_Hello Albert! how are you ? Чем занят ? :-)"));
    }
}
