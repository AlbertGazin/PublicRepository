public class Calculator {

    public static String errorMessage = "";

    public static String calculate(String text) {

        String[] operands = text.split(" ");

        if (!Validator.correctArraySize(operands)) {
            errorMessage = "-1";
            return Storage.MESSAGES_MAP.get("WRONG_FORMAT");
        }

        String firstNumber = operands[0].trim();
        String operator = operands[1].trim();
        String secondNumber = operands[2].trim();

        if (!Validator.checkOperator(operator)) {
            errorMessage = "-1";
            return Storage.MESSAGES_MAP.get("WRONG_OPERATION");
        }

        if (!Validator.checkValidNumbers(firstNumber, secondNumber)) {
            errorMessage = "-1";
            return Storage.MESSAGES_MAP.get("WRONG_NUMBERS");
        }

        if (Validator.arabNumbers(firstNumber)) {
            switch (operator) {
                case "+":
                    return String.valueOf(Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber));
                case "-":
                    return String.valueOf(Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber));
                case "*":
                    return String.valueOf(Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber));
                case "/":
                    return String.valueOf(Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber));
            }
        }

        if (Validator.romanNumbers(firstNumber)) {
            int arabEqualNumberFirst = Integer.parseInt(RomanDigitsParser.getArabEqualNumber(firstNumber));
            int arabEqualNumberSecond = Integer.parseInt(RomanDigitsParser.getArabEqualNumber(secondNumber));

            if (arabEqualNumberFirst == -1 || arabEqualNumberSecond == -1) {
                errorMessage = "-1";
                return Storage.MESSAGES_MAP.get("WRONG_NUMBERS");
            } else {
                switch (operator) {
                    case "+":
                        return RomanDigitsParser.getRomanNumber(arabEqualNumberFirst +
                                arabEqualNumberSecond);
                    case "-":
                        return RomanDigitsParser.getRomanNumber(arabEqualNumberFirst -
                                arabEqualNumberSecond);
                    case "*":
                        return RomanDigitsParser.getRomanNumber(arabEqualNumberFirst *
                                arabEqualNumberSecond);
                    case "/":
                        return RomanDigitsParser.getRomanNumber(arabEqualNumberFirst /
                                arabEqualNumberSecond);
                }
            }
        }
        return "";
    }
}
