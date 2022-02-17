package week3;

import static util.Assert.assertEquals;
import static week3.TaskT03N15.decryptPassword;
import static week3.TaskT03N15.encryptPassword;

public class TaskT03N15Test {
    public static void main(String[] args) {
        testEmptyPasswordEncrypt();
        testEmptyPasswordDecrypt();
        testOnlyDigitsPasswordEncrypt();
        testOnlyDigitsPasswordDecrypt();
        testOnlyWordsPasswordEncrypt();
        testOnlyWordsPasswordDecrypt();
        testOnlyWordsAndDigitsPasswordEncrypt();
        testOnlyWordsAndDigitsPasswordDecrypt();
    }

    public static void testEmptyPasswordEncrypt() {
        assertEquals(
                "Week3.TaskT03N15Test.testEmptyPasswordEncrypt",
                "", encryptPassword(""));
    }

    public static void testEmptyPasswordDecrypt() {
        assertEquals(
                "Week3.TaskT03N15Test.testEmptyPasswordDecrypt",
                "", decryptPassword(""));
    }

    public static void testOnlyDigitsPasswordEncrypt() {
        assertEquals(
                "Week3.TaskT03N15Test.testOnlyDigitsPasswordEncrypt",
                "234560", encryptPassword("123459"));
    }

    public static void testOnlyDigitsPasswordDecrypt() {
        assertEquals(
                "Week3.TaskT03N15Test.testOnlyDigitsPasswordDecrypt",
                "9012348", decryptPassword("0123459"));
    }

    public static void testOnlyWordsPasswordEncrypt() {
        assertEquals(
                "Week3.TaskT03N15Test.testOnlyWordsPasswordEncrypt",
                "tEStING", encryptPassword("TesTing"));
    }

    public static void testOnlyWordsPasswordDecrypt() {
        assertEquals(
                "Week3.TaskT03N15Test.testOnlyWordsPasswordDecrypt",
                "TesTing", decryptPassword("tEStING"));
    }

    public static void testOnlyWordsAndDigitsPasswordEncrypt() {
        assertEquals(
                "Week3.TaskT03N15Test.testOnlyWordsAndDigitsPasswordEncrypt",
                "tES89tING4706", encryptPassword("Tes78Ting3695"));
    }

    public static void testOnlyWordsAndDigitsPasswordDecrypt() {
        assertEquals(
                "Week3.TaskT03N15Test.testOnlyWordsAndDigitsPasswordDecrypt",
                "Tes78Ting3695", decryptPassword("tES89tING4706"));
    }
}
