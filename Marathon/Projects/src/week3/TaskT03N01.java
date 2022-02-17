package week3;

public class TaskT03N01 {
    private static final String PARSE_TYPE = "Substring";

    public static void main(String[] args) {
        System.out.println(getSymbolOfString("Test", 3, "Substring"));
    }

    public static String getSymbolOfString(String word, int charPosition, String parseType) {
        if (isWordEmpty(word)) {
            return "Word is empty";
        }
        if (isIndexCorrect(word, charPosition)) {
            return "Index should be correct";
        } else {
            return parseType.equals(PARSE_TYPE) ? word.substring(charPosition, charPosition + 1) :
                    String.valueOf(word.charAt(charPosition));
        }
    }

    public static boolean isWordEmpty(String word) {
        return word.length() == 0;
    }

    public static boolean isIndexCorrect(String word, int charPosition) {
        return (charPosition >= word.length() || charPosition < 0);
    }
}
