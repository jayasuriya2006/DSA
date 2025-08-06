package dsa.dp.test;

import dsa.dp.main.MinimumPathSum;

public class MinimumPathSumTest {
    public static void main(String[] args) {
        Object[][] testCases = new Object[][]{
                {
                        new int[][]{
                                {1, 3},
                                {1, 5}
                        },
                        7 // 1 → 1 → 5
                },
                {
                        new int[][]{
                                {1, 3, 1},
                                {1, 5, 1},
                                {4, 2, 1}
                        },
                        7 // 1 → 3 → 1 → 1 → 1
                },
                {
                        new int[][]{
                                {1, 2, 3}
                        },
                        6 // Only right moves: 1+2+3
                },
                {
                        new int[][]{
                                {1},
                                {2},
                                {3}
                        },
                        6 // Only down moves: 1+2+3
                },
                {
                        new int[][]{
                                {5}
                        },
                        5 // Single cell
                }
        };

        int testNum = 1;
        for (Object[] test : testCases) {
            int[][] grid = (int[][]) test[0];
            int expected = (int) test[1];

            int memo = MinimumPathSum.minimumPathSumMemo(grid);
            int tab = MinimumPathSum.minimumPathSumTabulation(grid);
            int space = MinimumPathSum.minimumPathSumTSpaceOptimized(grid);

            boolean passed = memo == expected && tab == expected && space == expected;

            System.out.printf("Test Case %d:\n", testNum++);
            System.out.printf("Expected: %d, Memo: %d, Tab: %d, SpaceOpt: %d\n", expected, memo, tab, space);
            System.out.println(passed ? "✅ Passed\n" : "❌ Failed\n");
        }
    }
}
