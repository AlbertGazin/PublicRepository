package week2;

public class TaskT02N06 {
    public static void main(String[] args) {
        System.out.println(factorial(0));
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
