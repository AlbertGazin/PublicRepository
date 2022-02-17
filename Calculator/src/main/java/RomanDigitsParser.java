import java.util.Map;

public class RomanDigitsParser {

    public static String getArabEqualNumber(String number) {
        return Storage.ROMAN_NUMBERS.getOrDefault(number, "-1");
    }

    public static String getRomanNumber(int operationResult) {
        String resultRoman = "";
        String sign = "";

        if (operationResult == 0) {
            return Storage.MESSAGES_MAP.get("ROMAN_0");
        }

        if (operationResult < 0) {
            sign = "-";
        }

        int operationResultOstatok = operationResult % 10;

        if ((Math.abs(operationResult) >= 1 && Math.abs(operationResult) < 10) ||
                (Math.abs(operationResult) >= 10 && operationResultOstatok == 0)) {
            resultRoman = sign + getKey(Storage.ROMAN_NUMBERS, Math.abs(operationResult));
        } else {
            resultRoman = sign + getKey(Storage.ROMAN_NUMBERS, Math.abs(operationResult - operationResultOstatok)) +
                    getKey(Storage.ROMAN_NUMBERS, operationResultOstatok);
        }
        return resultRoman;
    }

    public static String getKey(Map<String, String> map, int value) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(String.valueOf(value))) {
                return entry.getKey();
            }
        }
        return "-1";
    }
}