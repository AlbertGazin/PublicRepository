package week4;

public class TaskT04N09 {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 12}, {10, 11, 12, 90}, {100, 101, 102, 43}, {34, 56, 78, 99}};
        int[][] result = deleteRow(array, 0);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        result = deleteColumn(array, 0);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] deleteRow(int[][] array, int rowNumber) {
        if (rowNumber > array.length - 1) {
            return new int[][]{{-1}};
        }

        int[][] resultArray = new int[array.length][array[0].length];
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i < rowNumber) {
                    resultArray[i][j] = array[i][j];
                } else {
                    resultArray[i][j] = array[i + 1][j];
                }
            }
        }
        return resultArray;
    }

    public static int[][] deleteColumn(int[][] array, int columnNumber) {
        if (columnNumber > array[0].length - 1) {
            return new int[][]{{-1}};
        }

        int[][] resultArray = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length - 1; j++) {
                if (j < columnNumber) {
                    resultArray[i][j] = array[i][j];
                } else {
                    resultArray[i][j] = array[i][j + 1];
                }
            }
        }
        return resultArray;
    }
}