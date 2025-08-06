package dsa.dp.test;

import static dsa.dp.main.MaximumPathInGrid.*;

public class MaximumPathInGridTest {
    public static void main(String[] args) {

        Object[][] testCases = {
                // Format: {grid, expectedMaxSum}
                {
                        new int[][]{
                                {2, 1, 3},
                                {6, 5, 4},
                                {7, 8, 9}
                        },
                        17 // 3 -> 5 -> 9 = 17
                },
                {
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        },
                        18 // 3 -> 6 -> 9
                },
                {
                        new int[][]{
                                {10}
                        },
                        10 // Single cell
                },
                {
                        new int[][]{
                                {1, 2},
                                {9, 8}
                        },
                        11 // 9 -> 2
                },
                {
                        new int[][]{
                                {100, 2, 3},
                                {1, 1000, 5},
                                {4, 5, 600}
                        },
                        1700// 100 -> 1000 -> 600
                }
        };

        int testNum = 1;
        for (Object[] testCase : testCases) {
            int[][] grid = (int[][]) testCase[0];
            int expected = (int) testCase[1];

            int memo = minFallingPathSumMemo(grid);
            int tab = minFallingPathTabulation(grid);
            int spaceOpt = minFallingPathSpaceOptimized(grid);

            boolean pass = memo == expected && tab == expected && spaceOpt == expected;

            System.out.println("Test Case " + testNum + ":");
            System.out.println("Expected: " + expected);
            System.out.println("Memo: " + memo + ", Tab: " + tab + ", SpaceOpt: " + spaceOpt);
            System.out.println(pass ? "✅ Passed" : "❌ Failed");
            System.out.println();

            testNum++;
        }
    }
}
