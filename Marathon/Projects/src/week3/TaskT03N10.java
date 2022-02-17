package week3;

public class TaskT03N10 {
    public static void main(String[] args) {
        System.out.println(myName());
    }

    public static String myName() {
        StringBuilder stringBuilder = new StringBuilder();
        return String.valueOf(stringBuilder.append((char) 65).append((char) 108).append((char) 98).append((char) 101)
                .append((char) 114).append(((char) 116)));
    }
}
