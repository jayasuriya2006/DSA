package dsa.dp.test;

import dsa.dp.main.Triangle;

public class TriangleTest {
    public static void main(String[] args) {
        Object[][] testCases = new Object[][]{
                {
                        new int[][]{
                                {1},
                                {2, 3},
                                {3, 6, 7},
                                {8, 9, 6, 10}
                        },
                        21 // 1 → 3 → 7 → 9
                },
                {
                        new int[][]{
                                {2},
                                {4, 3},
                                {6, 5, 7},
                                {4, 1, 8, 3}
                        },
                        20
                },
                {
                        new int[][]{
                                {5}
                        },
                        5
                },
                {
                        new int[][]{
                                {1},
                                {2, 1}
                        },
                        3 // 1 + 2
                },
                {
                        new int[][]{
                                {1},
                                {2, 3},
                                {1, 5, 1}
                        },
                        9 // 1 + 3 + 5
                }
        };

        int testNum = 1;
        boolean allPassed = true;

        for (Object[] test : testCases) {
            int[][] triangle = (int[][]) test[0];
            int expected = (int) test[1];

            int memo = Triangle.maxSumPathInTriangleMemo(triangle);
            int tab = Triangle.maxSumPathInTriangleTabulation(triangle);
            int space = Triangle.maxSumPathInTriangleSpaceOptimized(triangle);

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
