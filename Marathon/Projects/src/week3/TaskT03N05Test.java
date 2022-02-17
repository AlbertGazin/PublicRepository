package week3;

import static util.Assert.assertEquals;
import static week3.TaskT03N05.changeWordsInString;

public class TaskT03N05Test {
    public static void main(String[] args) {
        testEmptyString();
        testStringWithoutAandO();
        testStringWithWordAOnly();
        testStringWithWordOOnly();
        testStringOne();
        testStringTwo();
        testStringThree();
        testStringFour();
    }

    public static void testEmptyString() {
        assertEquals(
                "Week3.TaskT03N05Test.testEmptyString",
                "The string is empty !",
                changeWordsInString(""));
    }

    public static void testStringWithoutAandO() {
        assertEquals(
                "Week3.TaskT03N05Test.testStringWithoutAandO",
                "String does not contain a(A) and o(O) words at the same time !",
                changeWordsInString("Line"));
    }

    public static void testStringWithWordAOnly() {
        assertEquals(
                "Week3.TaskT03N05Test.testStringWithWordAOnly",
                "String does not contain a(A) and o(O) words at the same time !",
                changeWordsInString("Car"));
    }

    public static void testStringWithWordOOnly() {
        assertEquals(
                "Week3.TaskT03N05Test.testStringWithWordOOnly",
                "String does not contain a(A) and o(O) words at the same time !",
                changeWordsInString("Cow"));
    }

    public static void testStringOne() {
        assertEquals(
                "Week3.TaskT03N05Test.testStringOne",
                "Boaleon",
                changeWordsInString("Boolean"));
    }

    public static void testStringTwo() {
        assertEquals(
                "Week3.TaskT03N05Test.testStringTwo",
                "BOALEON",
                changeWordsInString("BOOLEAN"));
    }

    public static void testStringThree() {
        assertEquals(
                "Week3.TaskT03N05Test.testStringThree",
                "OpricAT",
                changeWordsInString("ApricOT"));
    }

    public static void testStringFour() {
        assertEquals(
                "Week3.TaskT03N05Test.testStringFour",
                "Loaamoooada",
                changeWordsInString("Laaamooooda"));
    }
}