package week3;

public class TaskT03N12 {
    public static void main(String[] args) {
        System.out.println(getLongestWordFromSentence("Hello!!!!!!!!!!!!!!!!!!!! " +
                "How are you ? Congratulations, you are winner in the championship!"));
    }

    public static String getLongestWordFromSentence(String sentence) {
        String[] words = sentence.split(" ");
        String longestWord = "";
        for (String word : words) {
            if (word.replaceAll("[^a-zA-Z0-9а-яА-Я]", "").length() > longestWord.length()) {
                longestWord = word.replaceAll("[^a-zA-Z0-9а-яА-Я]", "");
            }
        }
        return longestWord;
    }
}
