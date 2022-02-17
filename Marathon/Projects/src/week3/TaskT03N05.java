package week3;

public class TaskT03N05 {
    public static void main(String[] args) {
        System.out.println(changeWordsInString("ApricOT"));
    }

    public static String changeWordsInString(String line) {
        if (line.length() == 0) {
            return "The string is empty !";
        }

        if (line.toLowerCase().contains("a") && line.toLowerCase().contains("o")) {
            StringBuilder result = new StringBuilder(line);
            int indexOfA = line.toUpperCase().indexOf("A");
            int indexOfO = line.toUpperCase().lastIndexOf("O");
            result.setCharAt(indexOfA, line.charAt(indexOfO));
            result.setCharAt(indexOfO, line.charAt(indexOfA));
            return String.valueOf(result);
        } else {
            return "String does not contain a(A) and o(O) words at the same time !";
        }
    }
}
