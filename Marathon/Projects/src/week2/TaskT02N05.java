package week2;

public class TaskT02N05 {
    public static void main(String[] args) {
        System.out.println(getCountOfDigitsInNumber(-10));
    }

    public static int getCountOfDigitsInNumber(int number) {
        if (number == 0) {
            return 1;
        }
        int count = 0;
        if (number > 0) {
            while (number > 0) {
                number /= 10;
                count++;
            }
            return count;
        } else {
            return -1;
        }
    }
}
