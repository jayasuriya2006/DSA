package dsa.dp.test;

import dsa.dp.main.GridUniquePathsII;

public class GridUniquePathsIITest {
    public static void main(String[] args) {
        Object[][] testCases = new Object[][] {
                {
                        new int[][] {
                                {0, 0, 0},
                                {0, -1, 0},
                                {0, 0, 0}
                        },
                        2
                },
                {
                        new int[][] {
                                {0, -1},
                                {0, 0}
                        },
                        1
                },
                {
                        new int[][] {
                                {0, -1},
                                {-1, 0}
                        },
                        0
                },
                {
                        new int[][] {
                                {0, 0},
                                {0, 0}
                        },
                        2
                },
                {
                        new int[][] {
                                {0, 0, 0, 0},
                                {0, -1, -1, 0},
                                {0, 0, 0, 0}
                        },
                        2
                }
        };

        boolean allPassed = true;
        int testNum = 1;

        for (Object[] test : testCases) {
            int[][] matrix = (int[][]) test[0];
            int expected = (int) test[1];

            int memo = GridUniquePathsII.getUniquePathIICountMemo(matrix);
            int tab = GridUniquePathsII.getUniquePathCountTabulation(matrix);
            int space = GridUniquePathsII.getUniquePathCountSpaceOptimized(matrix);

            boolean passed = (memo == expected && tab == expected && space == expected);

            System.out.printf("Test Case %d:\n", testNum);
            System.out.printf("Expected: %d, Memo: %d, Tab: %d, SpaceOpt: %d\n", expected, memo, tab, space);
            System.out.println(passed ? "✅ Passed\n" : "❌ Failed\n");

            if (!passed) allPassed = false;
            testNum++;
        }

        if (allPassed) {
            System.out.println("🎉 All test cases passed!");
        } else {
            System.out.println("⚠️ Some test cases failed.");
        }
    }
}
