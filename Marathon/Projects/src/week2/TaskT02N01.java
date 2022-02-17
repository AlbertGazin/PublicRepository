package week2;

public class TaskT02N01 {
    public static void main(String[] args) {
        System.out.println(getAvgNumber(45, 45, 32));
    }

    public static double getAvgNumber(double a, double b, double c) {
        if (a == b && b == c) {
            return a;
        }
        if (a == b || a == c) {
            return a;
        } else if (b == c) {
            return b;
        } else if ((a > b && a < c) || (a > c && a < b)) {
            return a;
        } else if ((b > a && b < c) || (b > c && b < a)) {
            return b;
        } else {
            return c;
        }
    }
}
