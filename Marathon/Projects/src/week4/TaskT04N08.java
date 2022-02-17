package week4;

public class TaskT04N08 {
    public static void main(String[] args) {
        int[][] students = {{16, 17, 15, 18}, {20, 20, 19, 21}, {18, 17, 19, 18}, {25, 24, 22, 23}, {17, 17, 18, 18}
                , {18, 19, 20, 21}, {19, 19, 19, 19}, {14, 17, 16, 19}, {23, 21, 22, 24}
                , {20, 15, 19, 16}, {22, 19, 17, 16}};
        int[][] testArray = getAvgStudentCount(students);
        for (int i = 0; i < testArray.length; i++) {
            for (int j = 0; j < testArray[i].length; j++) {
                System.out.print(i + 1 + " - " + testArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] getAvgStudentCount(int[][] students) {
        int[][] resultArray = new int[11][1];
        int avgCount = 0;
        for (int i = 0; i < students.length; i++) {
            avgCount = 0;
            for (int j = 0; j < students[i].length; j++) {
                avgCount += students[i][j];
            }
            avgCount /= 4;
            resultArray[i][0] = avgCount;
        }
        return resultArray;
    }
}
