package week3;

import java.util.Arrays;

public class TaskT03N14 {
    public static void main(String[] args) {
        String[] m = {"Wet", "cat", "Albert", "Banana", ""};
        System.out.println(Arrays.toString(sortArrayAlphabet(m)));
    }

    public static String[] sortArrayAlphabet(String[] words) {
        String[] errorArray = {"There are empty words in your array!"};
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals("") || words[j].equals("")) {
                    return errorArray;
                }
                if (String.valueOf(words[i].charAt(0)).toUpperCase()
                        .compareTo(String.valueOf(words[j].charAt(0)).toUpperCase()) > 0) {
                    String tmp = words[i];
                    words[i] = words[j];
                    words[j] = tmp;
                }
            }
        }
        return words;
    }
}
