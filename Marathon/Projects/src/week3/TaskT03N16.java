package week3;

public class TaskT03N16 {
    public static void main(String[] args) {
        String text = "Hello! Formula is (1 + 2y) * 7x - ((3/2x) + (8-6y)))";
        System.out.println(isParenthesesCorrect(text));
    }

    public static String isParenthesesCorrect(String text) {
        if (text.length() == 0) {
            return "Text is empty !";
        }
        String[] words = text.split("");
        int rightParentheses = 0;
        int leftParentheses = 0;
        int incorrectRightParenthes = 0;
        int tmpCountRightParentheses = 0;
        for (String word : words) {
            if (word.equals(")")) {
                rightParentheses++;
            }
            if (word.equals("(")) {
                leftParentheses++;
            }
        }
        if (leftParentheses == rightParentheses) {
            return "Скобки расставлены верно !";
        } else if (leftParentheses > rightParentheses) {
            return "Открывающих скобок больше, чем необходимо ! Количество = " + leftParentheses;
        } else {
            for (String word : words) {
                if (word.equals(")")) {
                    tmpCountRightParentheses++;
                }
                if (tmpCountRightParentheses > leftParentheses) {
                    break;
                }
                incorrectRightParenthes++;
            }
            return "Закрывающих скобок больше, чем необходимо ! Позиция в тексте неверной скобки = " +
                    incorrectRightParenthes;
        }
    }
}
