package week1;

import java.util.Scanner;

public class TaskT01N01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Max value = " + max(a, b));
    }

    public static int max(int a, int b) {
        return a >= b ? a : b;
    }
}
