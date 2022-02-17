package week1;

public class TaskT01N10 {
    public static void main(String[] args) {
        System.out.println("Reversed 700 = " + reverseNumber(700));
    }

    public static int reverseNumber(int k) {
        if (100 <= k && k <= 999) {
            int reversed = 0;
            int first = k % 10;
            k = k / 10;
            int second = k % 10;
            k = k / 10;
            int third = k % 10;
            reversed += first;
            reversed *= 10;
            reversed += second;
            reversed *= 10;
            reversed += third;
            return reversed;
        } else return -1;
    }
}
