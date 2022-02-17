package week2;

public class TaskT02N14 {
    public static void main(String[] args) {
        System.out.println(getSeason(30));
    }

    public static String getSeason(int monthNumber) {
        switch (monthNumber) {
            case 1:
            case 2:
            case 12:
                return "Зима";
            case 3:
            case 4:
            case 5:
                return "Весна";
            case 6:
            case 7:
            case 8:
                return "Лето";
            case 9:
            case 10:
            case 11:
                return "Осень";
            default:
                return "Номер месяца должен быть в диапазоне от 1 до 12";
        }
    }
}
