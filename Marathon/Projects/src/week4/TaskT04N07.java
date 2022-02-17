package week4;

public class TaskT04N07 {
    public static void main(String[] args) {
        int[][] array = getSpiralArray(7);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] getSpiralArray(int countLines) {
        int[][] resultArray = new int[countLines][countLines];
        int value = 1;
        int minCol = 0;
        int maxCol = countLines - 1;
        int minRow = 0;
        int maxRow = countLines - 1;
        while (value <= countLines * countLines) {
            for (int i = minCol; i <= maxCol; i++) {
                resultArray[minRow][i] = value;
                value++;
            }

            for (int i = minRow + 1; i <= maxRow; i++) {
                resultArray[i][maxCol] = value;
                value++;
            }

            for (int i = maxCol - 1; i >= minCol; i--) {
                resultArray[maxRow][i] = value;
                value++;
            }

            for (int i = maxRow - 1; i >= minRow + 1; i--) {
                resultArray[i][minCol] = value;
                value++;
            }

            minCol++;
            minRow++;
            maxCol--;
            maxRow--;
        }
        return resultArray;
    }
}
