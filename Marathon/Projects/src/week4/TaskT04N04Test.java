package week4;

import static util.Assert.assertEquals;
import static week4.TaskT04N04.*;

public class TaskT04N04Test {
    public static void main(String[] args) {
        testDrawX();
        testDrawSnowflake();
        testDrawSandClock();
        testDrawEmptyX();
        testDrawEmptySnowflake();
        testDrawEmptySandClock();
    }

    public static void testDrawX() {
        int[][] expected = {{1, 0, 0, 0, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 0, 0, 1, 0, 0}
                , {0, 0, 0, 1, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 1, 0, 0, 0}
                , {0, 0, 1, 0, 0, 0, 1, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 1, 0}, {1, 0, 0, 0, 0, 0, 0, 0, 1}};
        assertEquals("Week4.TaskT04N04Test.testDrawX", expected, drawX(9, 9));
    }

    public static void testDrawEmptyX() {
        int[][] expected = {};
        assertEquals("Week4.TaskT04N04Test.testDrawEmptyX", expected, drawX(0, 0));
    }

    public static void testDrawEmptySnowflake() {
        int[][] expected = {};
        assertEquals("Week4.TaskT04N04Test.testDrawEmptySnowflake", expected, drawSnowflake(0, 0));
    }

    public static void testDrawEmptySandClock() {
        int[][] expected = {};
        assertEquals("Week4.TaskT04N04Test.testDrawEmptySandClock", expected, drawSandClock(0, 0));
    }

    public static void testDrawSnowflake() {
        int[][] expected = {{1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0}
                , {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0}
                , {0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0}
                , {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0}
                , {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0}, {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0}
                , {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1}};
        assertEquals("Week4.TaskT04N04Test.testDrawSnowflake", expected, drawSnowflake(13, 13));
    }

    public static void testDrawSandClock() {
        int[][] expected = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                , {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}
                , {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}
                , {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}
                , {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}
                , {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}
                , {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}
                , {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}
                , {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        assertEquals("Week4.TaskT04N04Test.testDrawSandClock", expected, drawSandClock(17, 17));
    }
}