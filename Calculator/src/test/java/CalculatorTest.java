import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    public void testTwoGoodArabNumbers() {
        String expected = "72";
        String actual = Calculator.calculate("9 * 8");
        assertEquals(expected, actual);
    }

    public void testOneBadArabNumber() {
        String expected = Storage.MESSAGES_MAP.get("WRONG_NUMBERS");
        String actual = Calculator.calculate("9 * 11");
        assertEquals(expected, actual);
    }

    public void testTwoBadArabNumbers() {
        String expected = Storage.MESSAGES_MAP.get("WRONG_NUMBERS");
        String actual = Calculator.calculate("12 / 11");
        assertEquals(expected, actual);
    }

    public void testIfOneNumberIsZeroArabNumbers() {
        String expected = Storage.MESSAGES_MAP.get("WRONG_NUMBERS");
        String actual = Calculator.calculate("0 / 11");
        assertEquals(expected, actual);
    }

    public void testIfResultIsDoubleArabNumbers() {
        String expected = "0.5714285714285714";
        String actual = Calculator.calculate("4 / 7");
        assertEquals(expected, actual);
    }

    public void testIfResultZeroArabNumbers() {
        String expected = "0";
        String actual = Calculator.calculate("7 - 7");
        assertEquals(expected, actual);
    }

    public void testIfResultIsNegativeArabNumbers() {
        String expected = "-9";
        String actual = Calculator.calculate("1 - 10");
        assertEquals(expected, actual);
    }

    public void testIfWrongOrderArabNumbers() {
        String expected = Storage.MESSAGES_MAP.get("WRONG_OPERATION");
        String actual = Calculator.calculate("* 8 9");
        assertEquals(expected, actual);
    }

    public void testIfNotSpacesArabNumbers() {
        String expected = Storage.MESSAGES_MAP.get("WRONG_FORMAT");
        String actual = Calculator.calculate("4+7");
        assertEquals(expected, actual);
    }

    public void testTwoGoodRomanNumbers() {
        String expected = "LXIII";
        String actual = Calculator.calculate("IX * VII");
        assertEquals(expected, actual);
    }

    public void testOneBadRomanNumber() {
        String expected = Storage.MESSAGES_MAP.get("WRONG_NUMBERS");
        String actual = Calculator.calculate("XX - VII");
        assertEquals(expected, actual);
    }

    public void testTwoBadRomanNumbers() {
        String expected = Storage.MESSAGES_MAP.get("WRONG_NUMBERS");
        String actual = Calculator.calculate("XX - XII");
        assertEquals(expected, actual);
    }

    public void testIfResultIsZeroRomanNumbers() {
        String expected = Storage.MESSAGES_MAP.get("ROMAN_0");
        String actual = Calculator.calculate("IX - IX");
        assertEquals(expected, actual);
    }

    public void testIfResultIsNegativeRomanNumbers() {
        String expected = "-VI";
        String actual = Calculator.calculate("II - VIII");
        assertEquals(expected, actual);
    }

    public void testIfResultIfWrongOrderRomanNumbers() {
        String expected = Storage.MESSAGES_MAP.get("WRONG_OPERATION");
        String actual = Calculator.calculate("II VIII *");
        assertEquals(expected, actual);
    }

    public void testIfNotSpacesRomanNumbers() {
        String expected = Storage.MESSAGES_MAP.get("WRONG_FORMAT");
        String actual = Calculator.calculate("I*IX");
        assertEquals(expected, actual);
    }

    public void testIfResultIsDoubleRomanNumbers() {
        String expected = "IV";
        String actual = Calculator.calculate("IX / II");
        assertEquals(expected, actual);
    }
}