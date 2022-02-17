import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Storage.INSTRUCTIONS);

        while (true) {
            System.out.println(Storage.MESSAGES_MAP.get("PLEASE_ENTER_YOUR_TEXT"));

            String userText = scanner.nextLine();

            if (userText.equalsIgnoreCase(Storage.MESSAGES_MAP.get("EXIT"))) {
                System.out.println(Storage.MESSAGES_MAP.get("EXIT"));
                break;
            }

            String result = Calculator.calculate(userText);

            System.out.println(result);

            if (Calculator.errorMessage.equals("-1")) {
                break;
            }
        }
    }
}