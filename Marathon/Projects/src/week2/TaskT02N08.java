package week2;

public class TaskT02N08 {
    public static void main(String[] args) {
        System.out.println(getDigitalRoot(-999));
    }

    public static int getDigitalRoot(int number) {
        if (Math.abs(number) < 10) {
            return number;
        } else {
            while (Math.abs(number) > 9) {
                number = TaskT02N04.getSumDigitsOfNumber(number);
            }
        }
        return number;
    }
}
