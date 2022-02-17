package week2;

public class TaskT02N04 {
    public static void main(String[] args) {
        System.out.println(getSumDigitsOfNumber(1234));
    }

    public static int getSumDigitsOfNumber(int number) {
        int sum = 0;
        if (number >= 0) {
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            return sum;
        } else {
            return -1;
        }
    }
}
