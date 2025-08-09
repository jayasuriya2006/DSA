package dsa.dp.main;

import java.util.Arrays;

public class EvaluateBooleanExpressionToTrue {

    public static int getNoOfWaysForTrue(String exp) {
        int len = exp.length();
        int[][][] dp = new int[len][len][2];
        for (int[][] row : dp) {
            for (int[] r : row) {
                Arrays.fill(r, -1);
            }

        }
        return getNoOfWaysForTrue(0, exp.length() - 1, 1, exp, dp);
    }

    private static int getNoOfWaysForTrue(int i, int j, int isTrue, String exp, int[][][] dp) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue == 1) {
                return exp.charAt(i) == 'T' ? 1 : 0;
            } else {
                return exp.charAt(i) == 'F' ? 1 : 0;
            }
        }
        if (dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        int ways = 0;
        for (int p = i + 1; p <= j - 1; p = p + 2) {
            int leftTrue = getNoOfWaysForTrue(i, p - 1, 1, exp, dp);
            int leftFalse = getNoOfWaysForTrue(i, p - 1, 0, exp, dp);
            int rightTrue = getNoOfWaysForTrue(p + 1, j, 1, exp, dp);
            int rightFalse = getNoOfWaysForTrue(p + 1, j, 0, exp, dp);
            int curOpe = exp.charAt(p);
            if (curOpe == '&') {
                if (isTrue == 1) {
                    ways = ways + (leftTrue * rightTrue);
                } else {
                    ways = ways
                            + (leftTrue * rightFalse)
                            + (leftFalse * rightTrue)
                            + (leftFalse * rightFalse);
                }
            } else if (curOpe == '|') {
                if (isTrue == 1) {
                    ways = ways
                            + (leftTrue * rightFalse)
                            + (leftFalse * rightTrue)
                            + (leftTrue * rightTrue);
                } else {
                    ways = ways + (leftFalse * rightFalse);
                }
            } else if (curOpe == '^') {
                if (isTrue == 1) {
                    ways = ways
                            + (leftTrue * rightFalse)
                            + (leftFalse * rightTrue);
                } else {
                    ways = ways
                            + (leftFalse * rightFalse)
                            + (leftTrue * rightTrue);
                }
            }
        }
        return dp[i][j][isTrue] = ways;
    }
}
