package dsa.recursion.main;

public class SudokuSolver {

    public static void solveSudoku(char[][] board) {

        boolean[][] colPlaced = new boolean[9][9];
        boolean[][] rowPlaced = new boolean[9][9];
        boolean[][] boxPlaced = new boolean[9][9];

        //compute the present value
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    int val = board[row][col] - '1';
                    rowPlaced[row][val] = true;
                    colPlaced[col][val] = true;
                    boxPlaced[(3 * (row / 3)) + (col / 3)][val] = true;
                }
            }
        }

        solveSudoku(board, 0, 0, colPlaced, rowPlaced, boxPlaced);
    }

    private static boolean solveSudoku(char[][] board, int row, int column, boolean[][] colPlaced, boolean[][] rowPlaced, boolean[][] boxPlaced) {
        if (row == 9) return true;
        if (column == 9) {
            return solveSudoku(board, row + 1, 0, colPlaced, rowPlaced, boxPlaced);
        }
        if (board[row][column] != '.') {
            return solveSudoku(board, row, column + 1, colPlaced, rowPlaced, boxPlaced);
        }

        for (char item = '1'; item <= '9'; item++) {
            int val = item - '1';
            if (!colPlaced[column][val] && !rowPlaced[row][val] && !boxPlaced[(3 * (row / 3)) + (column / 3)][val]) {

                colPlaced[column][val] = true;
                rowPlaced[row][val] = true;
                boxPlaced[(3 * (row / 3)) + (column / 3)][val] = true;
                board[row][column] = item;

                //recursive
                if (solveSudoku(board, row, column + 1, colPlaced, rowPlaced, boxPlaced)) return true;

                //backtrack
                colPlaced[column][val] = false;
                rowPlaced[row][val] = false;
                boxPlaced[(3 * (row / 3)) + (column / 3)][val] = false;
                board[row][column] = '.';

            }
        }

        return false;
    }
}
