package week3;

public class TaskT03N15 {
    public static void main(String[] args) {
        System.out.println(encryptPassword(""));
        System.out.println(decryptPassword("aLBERT99"));
    }

    public static String encryptPassword(String password) {
        char[] chars = password.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char word : chars) {
            if (Character.isDigit(word)) {
                if (word == '9') {
                    result.append('0');
                } else {
                    result.append(Integer.parseInt(String.valueOf(word)) + 1);
                }
            } else {
                result.append(Character.isUpperCase(word) ? String.valueOf(word).toLowerCase() : String.valueOf(word).toUpperCase());
            }
        }
        return String.valueOf(result);
    }

    public static String decryptPassword(String password) {
        char[] chars = password.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char word : chars) {
            if (Character.isDigit(word)) {
                if (word == '0') {
                    result.append('9');
                } else {
                    result.append(Integer.parseInt(String.valueOf(word)) - 1);
                }
            } else {
                result.append(Character.isUpperCase(word) ? String.valueOf(word).toLowerCase() : String.valueOf(word).toUpperCase());
            }
        }
        return String.valueOf(result);
    }
}
