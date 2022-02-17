package week3;

public class TaskT03N03 {
    public static void main(String[] args) {
        System.out.println(halfOfString(""));
    }

    public static String halfOfString(String word) {
        return word.length() == 0 ? "String is empty !" :
                word.length() % 2 == 0 ? word.substring(0, word.length() / 2) : "Count of words in string is not even !";
    }
}