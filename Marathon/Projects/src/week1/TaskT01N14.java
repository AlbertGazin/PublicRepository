package week1;

public class TaskT01N14 {
    public static void main(String[] args) {
        System.out.println(task1(0, 5));
    }

    public static boolean task1(int x, int y) {
        return x > 2 && y > 3;
    }

    public static boolean task2(int x, int y) {
        return x > 1 || y > -2;
    }

    public static boolean task3(int x, int y) {
        return x >= 0 && y < 5;
    }

    public static boolean task4(int x) {
        return x >= 3 || x < -1;
    }

    public static boolean task5(int x) {
        return x > 3 && x < 10;
    }

    public static boolean task6(int x) {
        return !(x > 2);
    }

    public static boolean task7(int x) {
        return !(x > 0 && x < 5);
    }

    public static boolean task8(int x) {
        return (x > 10 && x <= 20);
    }

    public static boolean task9(int x, int y) {
        return (y > 0 && y <= 4 && x < 5);
    }
}
