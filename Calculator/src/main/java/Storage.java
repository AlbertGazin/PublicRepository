import java.util.*;

public class Storage {
    public static final Set<String> OPERATION_TYPES = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    public static final Set<String> ROMAN_DIGITS =
            new HashSet<>(Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"));

    public static final Set<String> ARAB_DIGITS =
            new HashSet<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));

    public static final String INSTRUCTIONS = "Инструкция :\nВы можете ввести числа от 1 до 10 " +
            "включительно (только целые). Калькулятор понимает только 4 вида операций, а именно + - * / .\n" +
            "Числа могут быть арабскими либо римскими.\nДля выхода нужно написать слово 'выход' в любом регистре.\n" +
            "Второй операнд должен быть отделён от первого пробелом, и третий операнд должен быть отделён от второго " +
            "пробелом.\nКалькулятор выполняет лишь целочисленное деление в случае римских цифр (без дробных частей).\n";

    public static final Map<String, String> MESSAGES_MAP = new HashMap<>() {{
        put("PLEASE_ENTER_YOUR_TEXT", "Пожалуйста, введите вашу операцию:");
        put("EXIT", "Выход");
        put("WRONG_OPERATION", "Невалидная операция.");
        put("WRONG_NUMBERS", "Некорректное(-ые) число(-а).");
        put("WRONG_FORMAT", "Неверный формат.");
        put("ROMAN_0", "Результат вашей операции = 0. Но среди римских цифр её нет.");
    }};

    public static final Map<String, String> ROMAN_NUMBERS = new HashMap<>() {{
        put("I", "1");
        put("II", "2");
        put("III", "3");
        put("IV", "4");
        put("V", "5");
        put("VI", "6");
        put("VII", "7");
        put("VIII", "8");
        put("IX", "9");
        put("X", "10");
        put("XX", "20");
        put("XXX", "30");
        put("XL", "40");
        put("L", "50");
        put("LX", "60");
        put("LXX", "70");
        put("LXXX", "80");
        put("XC", "90");
        put("C", "100");
    }};
}