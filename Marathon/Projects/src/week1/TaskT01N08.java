package week1;

import java.util.Scanner;

public class TaskT01N08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(printUserNumber(scanner.nextLine()));
    }

    public static String printUserNumber(String line) {
        try {
            double d = Double.parseDouble(line);
            return "Вы ввели число " + line;
        } catch (NumberFormatException e) {
            return "Вы ввели не число";
        }

    }
}
