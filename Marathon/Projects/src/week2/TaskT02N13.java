package week2;

public class TaskT02N13 {
    public static void main(String[] args) {
        System.out.println(getColorOfTrafficLight(59));
    }

    public static String getColorOfTrafficLight(int minutes) {
        if (minutes < 60) {
            while (minutes >= 5) {
                minutes -= 5;
            }
            return minutes >= 0 && minutes < 3 ? "Green" : "Red";
        } else {
            return "Количество минут с начала часа не может быть больше 59";
        }
    }
}
