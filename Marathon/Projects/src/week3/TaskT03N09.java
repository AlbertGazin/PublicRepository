package week3;

public class TaskT03N09 {
    private final static String TEXT = "Hello java guys";

    public static void main(String[] args) {
        printColoredText(2);
    }

    public static void printColoredText(int colorNumber) {
        switch (colorNumber) {
            case 0:
                System.out.println("\u001b[30m" + TEXT + "\u001b[0m");
                break;
            case 1:
                System.out.println("\u001b[31m" + TEXT + "\u001b[0m");
                break;
            case 2:
                System.out.println("\u001b[32m" + TEXT + "\u001b[0m");
                break;
            case 3:
                System.out.println("\u001b[33m" + TEXT + "\u001b[0m");
                break;
            case 4:
                System.out.println("\u001b[34m" + TEXT + "\u001b[0m");
                break;
            case 5:
                System.out.println("\u001b[35m" + TEXT + "\u001b[0m");
                break;
            case 6:
                System.out.println("\u001b[36m" + TEXT + "\u001b[0m");
                break;
            case 7:
                System.out.println("\u001b[37m" + TEXT + "\u001b[0m");
                break;
            default:
                System.out.println("You should put color number between 0 and 7");
        }
    }
}
