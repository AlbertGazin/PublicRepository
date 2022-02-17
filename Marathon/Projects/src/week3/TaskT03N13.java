package week3;

public class TaskT03N13 {
    public static void main(String[] args) {
        System.out.println(putUpperFirstWordsOfText("This is test string"));
    }

    public static String putUpperFirstWordsOfText(String text) {
        if (text.length() == 0) {
            return "Text is empty !";
        }
        StringBuilder resultText = new StringBuilder();
        String[] words = text.split(" ");
        for (String word : words) {
            if (word.length() > 0) {
                resultText.append(
                        word.replaceFirst(String.valueOf(word.charAt(0)), String.valueOf(word.charAt(0)).toUpperCase())).append(" ");
            }
        }
        return String.valueOf(resultText).substring(0, resultText.length() - 1);
    }
}
