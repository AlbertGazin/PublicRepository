package week2;

public class TaskT02N07 {
    public static void main(String[] args) {
        System.out.println(getNameOfDay(8));
    }

    public static String getNameOfDay(int day) {
        switch (day) {
            case (1):
                return "Понедельник";
            case (2):
                return "Вторник";
            case (3):
                return "Среда";
            case (4):
                return "Четверг";
            case (5):
                return "Пятница";
            case (6):
                return "Суббота";
            case (7):
                return "Воскресенье";
            default:
                return "Некорректно";
        }
    }
}
