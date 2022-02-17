package week2;

import static util.Assert.assertEquals;
import static week2.TaskT02N13.getColorOfTrafficLight;

public class TaskT02N13Test {
    public static void main(String[] args) {
        test0minutes();
        test29minutes();
        test37minutes();
        test59minutes();
        test60minutes();
    }

    public static void test0minutes() {
        assertEquals("Week2.TaskT02N13Test.test0minutes", "Green", getColorOfTrafficLight(0));
    }

    public static void test29minutes() {
        assertEquals("Week2.TaskT02N13Test.test29minutes", "Red", getColorOfTrafficLight(29));
    }

    public static void test37minutes() {
        assertEquals("Week2.TaskT02N13Test.test37minutes", "Green", getColorOfTrafficLight(37));
    }

    public static void test59minutes() {
        assertEquals("Week2.TaskT02N13Test.test59minutes", "Red", getColorOfTrafficLight(59));
    }

    public static void test60minutes() {
        assertEquals("Week2.TaskT02N13Test.test60minutes", "Количество минут с начала часа не может быть больше 59", getColorOfTrafficLight(60));
    }
}
