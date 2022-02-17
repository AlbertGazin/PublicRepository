package week3;

import static util.Assert.assertEquals;
import static week3.TaskT03N12.getLongestWordFromSentence;

public class TaskT03N12Test {
    public static void main(String[] args) {
        testEmptySentence();
        testSentenceWithoutWords();
        testSentenceFromSpacesOnly();
        testSentenceFromSpacesAndSymbols();
        testSentenceOne();
        testSentenceTwo();
    }

    public static void testEmptySentence() {
        assertEquals("Week3.TaskT03N12Test.testEmptySentence", "",
                getLongestWordFromSentence(""));
    }

    public static void testSentenceWithoutWords() {
        assertEquals("Week3.TaskT03N12Test.testSentenceWithoutWords", "",
                getLongestWordFromSentence("!?><_)^;"));
    }

    public static void testSentenceFromSpacesOnly() {
        assertEquals("Week3.TaskT03N12Test.testSentenceFromSpacesOnly", "",
                getLongestWordFromSentence("   "));
    }

    public static void testSentenceFromSpacesAndSymbols() {
        assertEquals("Week3.TaskT03N12Test.testSentenceFromSpacesAndSymbols", "",
                getLongestWordFromSentence(" ! > ;  "));
    }

    public static void testSentenceOne() {
        assertEquals("Week3.TaskT03N12Test.testSentenceOne", "friends",
                getLongestWordFromSentence("Hello!!!!!!!!!!!!!!!!!! my dear friends"));
    }

    public static void testSentenceTwo() {
        assertEquals("Week3.TaskT03N12Test.testSentenceTwo", "Congratulations",
                getLongestWordFromSentence("   Hello!!!!!!!!!!!!!!!!!! my dear friends! Congratulations!!!  "));
    }
}
