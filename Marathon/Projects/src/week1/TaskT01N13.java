package week1;

public class TaskT01N13 {
    public static void main(String[] args) {
        System.out.println(checkNaturalNumbers(5, 4));
    }

    public static double checkNaturalNumbers(int a, int b) {
        double k = a % b;
        double m = b % a;
        return k * m + 1;
    }
}
