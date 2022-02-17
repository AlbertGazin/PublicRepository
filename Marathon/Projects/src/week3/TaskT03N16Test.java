package week3;

import static util.Assert.assertEquals;
import static week3.TaskT03N16.isParenthesesCorrect;

public class TaskT03N16Test {
    public static void main(String[] args) {
        testEmptyText();
        testIfOnlyOneClosingPar();
        testIfOnlyOneOpeningPar();
        testIfCorrectCountOfParentheses();
    }

    public static void testEmptyText() {
        assertEquals("Week3.TaskT03N16Test.testEmptyText",
                "Text is empty !",
                isParenthesesCorrect(""));
    }

    public static void testIfOnlyOneOpeningPar() {
        assertEquals("Week3.TaskT03N16Test.testIfOnlyOneOpeningPar",
                "Открывающих скобок больше, чем необходимо ! Количество = 1",
                isParenthesesCorrect("("));
    }

    public static void testIfOnlyOneClosingPar() {
        assertEquals("Week3.TaskT03N16Test.testIfOnlyOneClosingPar",
                "Закрывающих скобок больше, чем необходимо ! Позиция в тексте неверной скобки = 0",
                isParenthesesCorrect(")"));
    }

    public static void testIfCorrectCountOfParentheses() {
        assertEquals("Week3.TaskT03N16Test.testIfCorrectCountOfParentheses",
                "Скобки расставлены верно !",
                isParenthesesCorrect("(()) () ((())) ()()"));
    }

}
