package util;

import java.util.ArrayList;
import java.util.Arrays;

public class Assert {
    public static void assertEquals(String testName, int expected, int actual) {
        if (expected == actual) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected = " + expected + ", actual = " + actual);
        }
    }

    public static void assertEquals(String testName, double expected, double actual) {
        if (expected == actual) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected = " + expected + ", actual = " + actual);
        }
    }

    public static void assertEquals(String testName, String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected = " + expected + ", actual = " + actual);
        }
    }

    public static void assertEquals(String testName, boolean expected, boolean actual) {
        if (expected == actual) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected = " + expected + ", actual = " + actual);
        }
    }

    public static void assertEquals(String testName, double[] expected, double[] actual) {
        if (Arrays.equals(expected, actual)) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected = " + Arrays.toString(expected) + ", actual = " + Arrays.toString(actual));
        }
    }

    public static void assertEquals(String testName, int[] expected, int[] actual) {
        if (Arrays.equals(expected, actual)) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected = " + Arrays.toString(expected) + ", actual = " + Arrays.toString(actual));
        }
    }

    public static void assertEquals(String testName, double[][] expected, double[][] actual) {
        if (Arrays.equals(expected, actual)) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected = " + Arrays.toString(expected) + ", actual = " + Arrays.toString(actual));
        }
    }

    public static void assertEquals(String testName, int[][] expected, int[][] actual) {
        if (Arrays.deepEquals(expected, actual)) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected = " + Arrays.toString(expected) + ", actual = " + Arrays.toString(actual));
        }
    }

    public static void assertEquals(String testName, String[] expected, String[] actual) {
        if (Arrays.equals(expected, actual)) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected = " + Arrays.toString(expected) + ", actual = " + Arrays.toString(actual));
        }
    }

    public static void assertEquals(String testName, ArrayList expected, ArrayList actual) {
        if ((expected.size() == actual.size()) && (expected.containsAll(actual) && actual.containsAll(expected))) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected = " + expected + ", actual = " + actual);
        }
    }
}
