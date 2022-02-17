package week4;

import static util.Assert.assertEquals;
import static week4.TaskT04N09.deleteColumn;
import static week4.TaskT04N09.deleteRow;

public class TaskT04N09Test {
    public static void main(String[] args) {
        testDeleteRowZero();
        testDeleteRowOne();
        testDeleteRowTwo();
        testDeleteRowThatNotExists();
        testDeleteColumnZero();
        testDeleteColumnOne();
        testDeleteColumnTwo();
        testDeleteColumnThatNotExists();
    }

    public static void testDeleteRowZero() {
        int[][] expected = {{10, 11, 12}, {100, 101, 102}, {0, 0, 0}};
        int[][] actual = {{1, 2, 3}, {10, 11, 12}, {100, 101, 102}};
        assertEquals("Week4.TaskT04N09Test.testDeleteRowZero", expected, deleteRow(actual, 0));
    }

    public static void testDeleteRowThatNotExists() {
        int[][] expected = {{-1}};
        int[][] actual = {{1, 2, 3}, {10, 11, 12}, {100, 101, 102}};
        assertEquals("Week4.TaskT04N09Test.testDeleteRowThatNotExists", expected, deleteRow(actual, 3));
    }

    public static void testDeleteRowOne() {
        int[][] expected = {{1, 2, 3, 23, 17}, {100, 60, 48, 101, 102}, {9, 4, 12, 5, 78}, {0, 0, 0, 0, 0}};
        int[][] actual = {{1, 2, 3, 23, 17}, {10, 11, 5, 12, 9}, {100, 60, 48, 101, 102}, {9, 4, 12, 5, 78}};
        assertEquals("Week4.TaskT04N09Test.testDeleteRowOne", expected, deleteRow(actual, 1));
    }

    public static void testDeleteRowTwo() {
        int[][] expected = {{1, 2, 3, 23, 17}, {10, 11, 5, 12, 9}, {9, 4, 12, 5, 78}, {0, 0, 0, 0, 0}};
        int[][] actual = {{1, 2, 3, 23, 17}, {10, 11, 5, 12, 9}, {100, 60, 48, 101, 102}, {9, 4, 12, 5, 78}};
        assertEquals("Week4.TaskT04N09Test.testDeleteRowTwo", expected, deleteRow(actual, 2));
    }

    public static void testDeleteColumnZero() {
        int[][] expected = {{2, 3, 0}, {11, 12, 0}, {101, 102, 0}};
        int[][] actual = {{1, 2, 3}, {10, 11, 12}, {100, 101, 102}};
        assertEquals("Week4.TaskT04N09Test.testDeleteColumnZero", expected, deleteColumn(actual, 0));
    }

    public static void testDeleteColumnThatNotExists() {
        int[][] expected = {{-1}};
        int[][] actual = {{1, 2, 3}, {10, 11, 12}, {100, 101, 102}};
        assertEquals("Week4.TaskT04N09Test.testDeleteColumnThatNotExists", expected, deleteColumn(actual, 3));
    }

    public static void testDeleteColumnOne() {
        int[][] expected = {{1, 3, 23, 17, 0}, {10, 5, 12, 9, 0}, {100, 48, 101, 102, 0}, {9, 12, 5, 78, 0}};
        int[][] actual = {{1, 2, 3, 23, 17}, {10, 11, 5, 12, 9}, {100, 60, 48, 101, 102}, {9, 4, 12, 5, 78}};
        assertEquals("Week4.TaskT04N09Test.testDeleteColumnOne", expected, deleteColumn(actual, 1));
    }

    public static void testDeleteColumnTwo() {
        int[][] expected = {{1, 2, 23, 17, 0}, {10, 11, 12, 9, 0}, {100, 60, 101, 102, 0}, {9, 4, 5, 78, 0}};
        int[][] actual = {{1, 2, 3, 23, 17}, {10, 11, 5, 12, 9}, {100, 60, 48, 101, 102}, {9, 4, 12, 5, 78}};
        assertEquals("Week4.TaskT04N09Test.testDeleteColumnTwo", expected, deleteColumn(actual, 2));
    }
}
