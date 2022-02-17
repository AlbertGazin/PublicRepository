package week4;

public class TaskT04N03 {
    public static void main(String[] args) {
        int[][] testArray = getMultiplicationTable(0, 0);
        for (int i = 0; i < testArray.length; i++) {
            for (int j = 0; j < testArray[i].length; j++) {
                System.out.print(testArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] getMultiplicationTable(int linesNumber, int columnsNumber) {
        int[][] resultArray = new int[linesNumber][columnsNumber];
        for (int i = 0; i < linesNumber; i++) {
            for (int j = 0; j < columnsNumber; j++) {
                resultArray[i][j] = (i + 1) * (j + 1);
            }
        }
        return resultArray;
    }
}
