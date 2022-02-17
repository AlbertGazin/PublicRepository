package week1;

public class TaskT01N15 {
    public static void main(String[] args) {
        System.out.println(task5(15, 3, 4));
    }

    public static boolean task1(int x, int y) {
        return (x % 2 != 0 && y % 2 != 0);
    }

    public static boolean task2(int x, int y) {
        return (x < 20 && y > 20) || (x > 20 && y < 20);
    }

    public static boolean task3(int x, int y) {
        return (x == 0 || y == 0);
    }

    public static boolean task4(int x, int y, int z) {
        return (x < 0 && y < 0 && z < 0);
    }

    public static boolean task5(int x, int y, int z) {
        return (x % 5 == 0) ^ (y % 5 == 0) ^ (z % 5 == 0) ^ (x % 5 == 0 && y % 5 == 0 && z % 5 == 0);
    }

    public static boolean task6(int x, int y, int z) {
        return (x > 100 || y > 100 || z > 100);
    }
}
