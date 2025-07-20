package dsa.array.main;

public class SetMatrixZeroes {

    //TC - O( n ^ 3)
    //SC - O(1)
    public static void setMatrixZeros_Brut(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        //mark -1 instead of 0. if we mark as 0 then it will affect the matrix
        //O( (n * m) * (n + m))
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (matrix[row][col] == 0) {
                    markRowAsNegative(matrix, row, m);
                    markColAsNegative(matrix, col, n);
                }
            }
        }

        //iterate the arr again and covert -1 to 0
        //O(n * m)
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (matrix[row][col] == -1) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    //TC - O( n ^ 2)
    //SC - O(n + m)
    public static void setMatrixZeros_Better(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        //keep separate tracker
        boolean[] rowTrack = new boolean[n];
        boolean[] colTrack = new boolean[m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (matrix[row][col] == 0) {
                    rowTrack[row] = true;
                    colTrack[col] = true;
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (rowTrack[row] || colTrack[col]) {
                    matrix[row][col] = 0;
                }
            }
        }


    }

    //same approach of better, but use the same matrix for tracking
    //TC - O( n ^ 2)
    //SC - O(1)
    public static void setMatrixZeros_Optimal(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        //we are going to use 0th row and 0th col as a tracker
        //Since these are common points we need separate marker
        boolean zeroThRow = false;
        boolean zeroThCol = false;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {

                if (matrix[row][col] == 0) {
                    if (row == 0) {
                        zeroThRow = true;
                    }
                    if (col == 0) {
                        zeroThCol = true;
                    }
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;

                }
            }

        }

        //first update the 1 to n and 1 to m values, so that tracker won't change
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        //check for 0th row and column
        if (zeroThRow) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }

        if (zeroThCol) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }


    }

    private static void markRowAsNegative(int[][] matrix, int rowNumber, int m) {
        for (int i = 0; i < m; i++) {
            //Ignore the zeros, if we convert the zeros it will create a problem
            if (matrix[rowNumber][i] != 0) {
                matrix[rowNumber][i] = -1;
            }
        }
    }

    private static void markColAsNegative(int[][] matrix, int colNumber, int n) {
        for (int i = 0; i < n; i++) {
            //Ignore the zeros, if we convert the zeros it will create a problem
            if (matrix[i][colNumber] != 0) {
                matrix[i][colNumber] = -1;
            }
        }
    }
}
