package week3;

public class TaskT03N07 {
    public static void main(String[] args) {
        System.out.println(changeFirstAndLastWordsInSentence("How   test is     done   "));
    }

    public static String changeFirstAndLastWordsInSentence(String sentence) {
        if (sentence.trim().length() == 0) {
            return "String is empty !";
        }

        StringBuilder resultSentence = new StringBuilder();
        String[] words = sentence.split(" ");
        String tmp = words[0];
        words[0] = words[words.length - 1];
        words[words.length - 1] = tmp;
        for (String s : words) {
            resultSentence.append(s + " ");
        }
        return String.valueOf(resultSentence);
    }
}
