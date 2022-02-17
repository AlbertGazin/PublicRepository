package week3;

import java.util.Arrays;

public class TaskT03N04 {
    public static void main(String[] args) {
        System.out.println(isWordPalindrome("Test"));
    }

    public static boolean isWordPalindrome(String word) {
        if (word.length() == 0) {
            return false;
        }

        char[] actualOrder = word.toUpperCase().toCharArray();
        char[] reversedOrder = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            reversedOrder[i] = word.toUpperCase().charAt(word.length() - (i + 1));
        }
        return Arrays.equals(actualOrder, reversedOrder);
    }
}
