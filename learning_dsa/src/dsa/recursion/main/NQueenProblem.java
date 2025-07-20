package dsa.recursion.main;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        boolean[] colPlaced = new boolean[n];
        boolean[] diagnalPlaced1 = new boolean[2 * (n)];
        boolean[] diagnalPlaced2 = new boolean[2 * (n)];
        char[][] temp = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = '.';
            }
        }
        solveNQueens1(0, n, temp, colPlaced, diagnalPlaced1, diagnalPlaced2, ans);
        return ans;

    }

    public static boolean solveNQueens1(int row, int n, char[][] temp, boolean[] colPlaced, boolean[] diagnalPlaced1, boolean[] diagnalPlaced2, List<List<String>> ans) {

        if (row == n) {
            buildAns(temp, ans);
            return true;
        }
        for (int col = 0; col < n; col++) {
            if (checkCanPlace(row, col, colPlaced, diagnalPlaced1, diagnalPlaced2, n)) {
                colPlaced[col] = true;
                diagnalPlaced1[row + col] = true;
                diagnalPlaced2[(n - 1) + (row - col)] = true;
                temp[row][col] = 'Q';
                if (solveNQueens1(row + 1, n, temp, colPlaced, diagnalPlaced1, diagnalPlaced2, ans)) {
                    return true;
                }
                colPlaced[col] = false;
                diagnalPlaced1[row + col] = false;
                diagnalPlaced2[(n - 1) + (row - col)] = false;
                temp[row][col] = '.';

            }
        }
        return false;
    }

    private static void buildAns(char[][] temp, List<List<String>> ans) {
        List<String> ansT = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < temp.length; j++) {
                str.append(temp[i][j]);
            }
            ansT.add(new String(str));
        }
        ans.add(ansT);

    }

    private static boolean checkCanPlace(int r, int c, boolean[] colPlaced, boolean[] diagnalPlaced1, boolean[] diagnalPlaced2, int n) {
        if (colPlaced[c]) return false;
        if (diagnalPlaced1[r + c]) return false;
        if (diagnalPlaced2[(n - 1) + (r - c)]) return false;
        return true;

    }

}
