package week4;

public class TaskT04N05 {
    public static void main(String[] args) {
        int[][] array = drawArray2(12, 12);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] drawArray1(int countLines, int countRows) {
        int[][] resultArray = new int[countLines][countRows];
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                if (i == 0 || j == 0) {
                    resultArray[i][j] = 1;
                } else {
                    resultArray[i][j] = resultArray[i - 1][j] + resultArray[i][j - 1];
                }
            }
        }
        return resultArray;
    }

    public static int[][] drawArray2(int countLines, int countColumns) {
        if (countLines == 0 || countColumns == 0) {
            return new int[][]{{-1}};
        }

        int[][] resultArray = new int[countLines][countColumns];
        resultArray[0][0] = 1;
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                if (i == 0) {
                    if (j != 0) {
                        resultArray[i][j] = resultArray[i][j - 1] + 1;
                    }
                } else {
                    if (resultArray[i - 1][j] == (resultArray.length)) {
                        resultArray[i][j] = resultArray[i - 1][j] - (resultArray.length - 1);
                    } else {
                        resultArray[i][j] = resultArray[i - 1][j] + 1;
                    }
                }
            }
        }
        return resultArray;
    }
}