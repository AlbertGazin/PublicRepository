package week1;

public class TaskT01N11 {
    public static void main(String[] args) {
        System.out.println(findOriginalNumber(525));
    }

    public static int findOriginalNumber(int k) {
        if (k >= 100 && k <= 999) {
            int result = 0;
            int second = k % 10;
            k = k / 10;
            int third = k % 10;
            k = k / 10;
            int first = k % 10;
            result += first;
            result *= 10;
            result += second;
            result *= 10;
            result += third;
            return result;
        } else return -1;
    }
}
