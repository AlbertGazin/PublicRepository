package week3;

import static week3.TaskT03N01.isWordEmpty;

public class TaskT03N02 {
    private final static String COMPARE_TYPE_SUBSTR = "Substring";

    public static void main(String[] args) {
        System.out.println(isBeginCharEqualsEndChar("Test", "Substring"));
    }

    public static boolean isBeginCharEqualsEndChar(String word, String compareType) {
        return compareType.equals(COMPARE_TYPE_SUBSTR) ? isBeginCharEqualsEndCharSubstr(word)
                : isBeginCharEqualsEndCharCharAt(word);

    }

    public static boolean isBeginCharEqualsEndCharSubstr(String word) {
        return !isWordEmpty(word) &&
                word.toUpperCase().substring(0, 1).equals(word.toUpperCase().substring(word.length() - 1));
    }

    public static boolean isBeginCharEqualsEndCharCharAt(String word) {
        return !isWordEmpty(word) &&
                word.toUpperCase().charAt(0) == word.toUpperCase().charAt(word.length() - 1);
    }
}
