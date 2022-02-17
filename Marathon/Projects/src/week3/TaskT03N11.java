package week3;

public class TaskT03N11 {
    public static void main(String[] args) {
        System.out.println(changeSentence("Hello Albert! how are you ? Чем занят ? :-)"));
        System.out.println(changeSentence(""));
    }

    public static String changeSentence(String sentence) {
        return sentence.replaceAll("[^A-Za-zА-Яа-я0-9 ]", "").toUpperCase();
    }
}