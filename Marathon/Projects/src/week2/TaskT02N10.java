package week2;

public class TaskT02N10 {
    public static void main(String[] args) {
        System.out.println(isNumberEndsWithEven(10.97));
    }

    public static boolean isNumberEndsWithEven(double number) {
        String stringNumber = String.valueOf(number);
        String mainPartOfNumber = stringNumber.substring(0, stringNumber.indexOf('.'));
        String decimalPartOfNumber = stringNumber.substring(stringNumber.indexOf('.') + 1);
        if (decimalPartOfNumber.equals("0")) {
            int lastDigitOfNumber = Integer.parseInt(mainPartOfNumber) % 10;
            return lastDigitOfNumber % 2 == 0;
        } else {
            int lastDigitOfNumber = Integer.parseInt(decimalPartOfNumber) % 10;
            return lastDigitOfNumber % 2 == 0;
        }
    }
}
