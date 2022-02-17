public class Validator {

    public static boolean checkOperator(String text) {
        return Storage.OPERATION_TYPES.contains(text);
    }

    public static boolean checkValidNumbers(String firstNumber, String secondNumber) {
        return (Storage.ROMAN_DIGITS.contains(firstNumber) && Storage.ROMAN_DIGITS.contains(secondNumber)) ||
                (Storage.ARAB_DIGITS.contains(firstNumber) && Storage.ARAB_DIGITS.contains(secondNumber));
    }

    public static boolean arabNumbers(String number) {
        return Storage.ARAB_DIGITS.contains(number);
    }

    public static boolean romanNumbers(String number) {
        return Storage.ROMAN_DIGITS.contains(number);
    }

    public static boolean correctArraySize(String[] array) {
        return array.length == 3;
    }
}