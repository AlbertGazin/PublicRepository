package week1;

import static java.lang.Math.*;

public class TaskT01N09 {
    public static void main(String[] args) {
        task1(1, 2);
        task2(1);
        task3(1, 2, 3, 4);
        task4(1);
        task5(1);
    }

    public static double task1(int x1, int x2) {
        return sqrt(pow(x1, 2) + pow(x2, 2));
    }

    public static double task2(int x) {
        return sqrt(1 - pow(sin(x), 2));
    }

    public static double task3(int a, int b, int c, int x) {
        return 1 / sqrt(a * pow(x, 2) + b * x + c);
    }

    public static double task4(int x) {
        return sqrt(x + 1) + sqrt(x - 1) / (2 * sqrt(x));
    }

    public static double task5(int x) {
        return abs(x) + abs(x + 1);
    }
}
