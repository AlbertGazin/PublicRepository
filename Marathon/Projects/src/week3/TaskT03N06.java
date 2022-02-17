package week3;

public class TaskT03N06 {
    public static void main(String[] args) {
        System.out.println(lastValueFromCsv("Test;t;"));
    }

    public static String lastValueFromCsv(String line) {
        if (line.length() == 0) {
            return "String is empty !";
        }
        if (!line.contains(";")) {
            return "String does not contain ';'";
        }
        String[] words = line.split(";");
        return words[words.length - 1];
    }
}
