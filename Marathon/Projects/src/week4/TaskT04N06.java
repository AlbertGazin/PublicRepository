package week4;

public class TaskT04N06 {
    public static void main(String[] args) {
        int[][] testArray = fillArrayR();
        for (int i = 0; i < testArray.length; i++) {
            for (int j = 0; j < testArray[i].length; j++) {
                System.out.print(testArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] fillArrayA() {
        int[][] resultArray = new int[12][10];
        resultArray[0][0] = 1;
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if ((j == 0)) {
                    resultArray[i][j] = resultArray[i - 1][(resultArray[i].length - 1)] + 1;
                } else {
                    resultArray[i][j] = resultArray[i][j - 1] + 1;
                }
            }
        }
        return resultArray;
    }

    public static int[][] fillArrayB() {
        int[][] resultArray = new int[12][10];
        resultArray[0][0] = 1;
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if ((j == 0)) {
                    resultArray[i][j] = resultArray[i - 1][j] + 1;
                } else {
                    resultArray[i][j] = resultArray[i][j - 1] + 12;
                }
            }
        }
        return resultArray;
    }

    public static int[][] fillArrayV() {
        int[][] resultArray = new int[12][10];
        resultArray[0][0] = 10;
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if ((j == 0)) {
                    resultArray[i][j] = resultArray[i - 1][j] + 10;
                } else {
                    resultArray[i][j] = resultArray[i][j - 1] - 1;
                }
            }
        }
        return resultArray;
    }

    public static int[][] fillArrayG() {
        int[][] resultArray = new int[12][10];
        resultArray[0][0] = 12;
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if ((j == 0)) {
                    resultArray[i][j] = resultArray[i - 1][j] - 1;
                } else {
                    resultArray[i][j] = resultArray[i][j - 1] + 12;
                }
            }
        }
        return resultArray;
    }

    public static int[][] fillArrayD() {
        int[][] resultArray = new int[10][12];
        resultArray[0][0] = 1;
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    resultArray[i][j] = resultArray[i][j - 1] + 1;
                    continue;
                }
                if (j == 0) {
                    resultArray[i][j] = resultArray[i - 1][resultArray[i].length - 1] + resultArray[i].length;
                } else if (i % 2 == 0) {
                    resultArray[i][j] = resultArray[i][j - 1] + 1;
                } else {
                    resultArray[i][j] = resultArray[i][j - 1] - 1;
                }
            }
        }
        return resultArray;
    }

    public static int[][] fillArrayE() {
        int[][] resultArray = new int[12][10];
        resultArray[0][0] = 1;
        for (int i = 1; i < resultArray.length; i++) {
            resultArray[i][0] = resultArray[i - 1][0] + 1;
        }
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                if (j == 0) {
                    continue;
                }
                if (j % 2 != 0) {
                    if (i == 0) {
                        resultArray[i][j] = resultArray[i][j - 1] + (resultArray.length * 2 - 1);
                    } else {
                        resultArray[i][j] = resultArray[i - 1][j] - 1;
                    }
                } else {
                    if (i == 0) {
                        resultArray[i][j] = resultArray[i][j - 1] + 1;
                    } else {
                        resultArray[i][j] = resultArray[i - 1][j] + 1;
                    }
                }
            }
        }
        return resultArray;
    }

    public static int[][] fillArrayJe() {
        int[][] resultArray = new int[12][10];
        resultArray[0][0] = 111;
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                if (j == 0 && i == 0) {
                    continue;
                }
                if (j == 0) {
                    resultArray[i][j] = resultArray[i - 1][j] - (resultArray.length - 2);
                } else {
                    resultArray[i][j] = resultArray[i][j - 1] + 1;
                }
            }
        }
        return resultArray;
    }

    public static int[][] fillArrayZ() {
        int[][] resultArray = new int[12][10];
        resultArray[0][0] = 109;
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                if (j == 0 && i == 0) {
                    continue;
                }
                if (j == 0) {
                    resultArray[i][j] = resultArray[i - 1][j] + 1;
                } else {
                    resultArray[i][j] = resultArray[i][j - 1] - resultArray.length;
                }
            }
        }
        return resultArray;
    }

    public static int[][] fillArrayI() {
        int[][] resultArray = new int[12][10];
        resultArray[0][0] = 120;
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                if (j == 0 && i == 0) {
                    continue;
                }
                if (j == 0) {
                    resultArray[i][j] = resultArray[i - 1][resultArray[i].length - 1] - 1;
                } else {
                    resultArray[i][j] = resultArray[i][j - 1] - 1;
                }
            }
        }
        return resultArray;
    }

    public static int[][] fillArrayK() {
        int[][] resultArray = new int[12][10];
        resultArray[0][0] = 120;
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                if (j == 0 && i == 0) {
                    continue;
                }
                if (j == 0) {
                    resultArray[i][j] = resultArray[i - 1][j] - 1;
                } else {
                    resultArray[i][j] = resultArray[i][j - 1] - resultArray.length;
                }
            }
        }
        return resultArray;
    }

    public static int[][] fillArrayL() {
        int[][] resultArray = new int[12][10];
        resultArray[0][0] = 120;
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                if (j == 0 && i == 0) {
                    continue;
                }
                if (i % 2 != 0) {
                    if (j == 0) {
                        resultArray[i][j] = resultArray[i - 1][resultArray[i][j]] - (resultArray[i].length * 2 - 1);
                    } else {
                        resultArray[i][j] = resultArray[i][j - 1] + 1;
                    }
                } else {
                    if (j == 0) {
                        resultArray[i][j] = resultArray[i - 1][j] - 1;
                    } else {
                        resultArray[i][j] = resultArray[i][j - 1] - 1;
                    }
                }
            }
        }
        return resultArray;
    }

    public static int[][] fillArrayM() {
        int[][] resultArray = new int[12][10];
        resultArray[0][0] = 10;
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                if (j == 0 && i == 0) {
                    continue;
                }
                if (i % 2 != 0) {
                    if (j == 0) {
                        resultArray[i][j] = resultArray[i - 1][j] + 1;
                    } else {
                        resultArray[i][j] = resultArray[i][j - 1] + 1;
                    }
                } else {
                    if (j == 0) {
                        resultArray[i][j] = resultArray[i - 1][j] + resultArray[i].length * 2 - 1;
                    } else {
                        resultArray[i][j] = resultArray[i][j - 1] - 1;
                    }
                }
            }
        }
        return resultArray;
    }

    public static int[][] fillArrayN() {
        int[][] resultArray = new int[12][10];
        resultArray[0][0] = 120;
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                if (j == 0 && i == 0) {
                    continue;
                }
                if (j % 2 != 0) {
                    if (i == 0) {
                        resultArray[i][j] = resultArray[i][j - 1] - resultArray[i].length * 2 - 3;
                    } else {
                        resultArray[i][j] = resultArray[i - 1][j] + 1;
                    }
                } else {
                    if (i == 0) {
                        resultArray[i][j] = resultArray[i][j - 1] - 1;
                    } else {
                        resultArray[i][j] = resultArray[i - 1][j] - 1;
                    }
                }
            }
        }
        return resultArray;
    }

    public static int[][] fillArrayO() {
        int[][] resultArray = new int[12][10];
        resultArray[0][0] = 12;
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                if (j == 0 && i == 0) {
                    continue;
                }
                if (j % 2 != 0) {
                    if (i == 0) {
                        resultArray[i][j] = resultArray[i][j - 1] + 1;
                    } else {
                        resultArray[i][j] = resultArray[i - 1][j] + 1;
                    }
                } else {
                    if (j == 0) {
                        resultArray[i][j] = resultArray[i - 1][j] - 1;
                    } else {
                        if (i == 0) {
                            resultArray[i][j] = resultArray[i][j - 1] + resultArray.length * 2 - 1;
                        } else {
                            resultArray[i][j] = resultArray[i - 1][j] - 1;
                        }
                    }
                }
            }
        }
        return resultArray;
    }

    public static int[][] fillArrayP() {
        int[][] resultArray = new int[12][10];
        resultArray[0][0] = 111;
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                if (j == 0 && i == 0) {
                    continue;
                }
                if (i % 2 != 0) {
                    if (j == 0) {
                        resultArray[i][j] = resultArray[i - 1][resultArray[i].length - 1] - resultArray.length + 2;
                    } else {
                        resultArray[i][j] = resultArray[i][j - 1] - 1;
                    }
                } else {
                    if (j == 0) {
                        resultArray[i][j] = resultArray[i - 1][resultArray[i].length - 1] - resultArray.length + 2;
                    } else {
                        resultArray[i][j] = resultArray[i][j - 1] + 1;
                    }
                }
            }
        }
        return resultArray;
    }

    public static int[][] fillArrayR() {
        int[][] resultArray = new int[12][10];
        resultArray[0][0] = 109;
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                if (j == 0 && i == 0) {
                    continue;
                }
                if (j % 2 != 0) {
                    if (i == 0) {
                        resultArray[i][j] = resultArray[i][j - 1] - 1;
                    } else {
                        resultArray[i][j] = resultArray[i - 1][j] - 1;
                    }
                } else {
                    if (j == 0) {
                        resultArray[i][j] = resultArray[i - 1][j] + 1;
                    } else {
                        if (i == 0) {
                            resultArray[i][j] = resultArray[i][j - 1] - resultArray.length * 2 + 1;
                        } else {
                            resultArray[i][j] = resultArray[i - 1][j] + 1;
                        }
                    }
                }
            }
        }
        return resultArray;
    }
}
