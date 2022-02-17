package week1;

public class TaskT01N07 {
    public static void main(String[] args) {
        System.out.println("Pi = " + Pi());
    }

    public static String Pi() {
        String pi = String.valueOf(Math.PI).substring(0, 4);
        return pi;
    }
}
