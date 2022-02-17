package week4;

public class TaskT04N04 {
    public static void main(String[] args) {
        int[][] testArray = drawSandClock(0, 0);
        for (int i = 0; i < testArray.length; i++) {
            for (int j = 0; j < testArray[i].length; j++) {
                System.out.print(testArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] drawX(int lineCount, int columnCount) {
        int[][] resultArray = new int[lineCount][columnCount];
        for (int i = 0; i < lineCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if ((i == j) || (i + 1 == resultArray.length - j)) {
                    resultArray[i][j] = 1;
                }
            }
        }
        return resultArray;
    }

    public static int[][] drawSnowflake(int lineCount, int rowCount) {
        int[][] resultArray = new int[lineCount][rowCount];
        for (int i = 0; i < lineCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                if ((i == j) || (i + 1 == resultArray.length - j) || (j == (resultArray.length - 1) / 2)
                        || (i == (resultArray.length - 1) / 2)) {
                    resultArray[i][j] = 1;
                }
            }
        }
        return resultArray;
    }

    public static int[][] drawSandClock(int lineCount, int rowCount) {
        int[][] resultArray = new int[lineCount][rowCount];
        for (int i = 0; i < lineCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                if ((i == j) || (i + 1 == resultArray.length - j) || ((j > i) && (j < resultArray.length - i))
                        || ((j < i) && (j + 1 > resultArray.length - i))) {
                    resultArray[i][j] = 1;
                }
            }
        }
        return resultArray;
    }
}
