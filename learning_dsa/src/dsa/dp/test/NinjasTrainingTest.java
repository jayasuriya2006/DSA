package dsa.dp.test;

import dsa.dp.main.NinjasTraining;

public class NinjasTrainingTest {
    public static void main(String[] args) {
        // Each test: {input points, expected result}
        Object[][] testCases = new Object[][]{
                // Test case 1: Sample case
                {
                        new int[][]{
                                {10, 40, 70},
                                {20, 50, 80},
                                {30, 60, 90}
                        },
                        210
                },

                // Test case 2: All tasks have same value
                {
                        new int[][]{
                                {10, 10, 10},
                                {10, 10, 10},
                                {10, 10, 10}
                        },
                        30 // Max without repeating task each day
                },

                // Test case 3: Only one day
                {
                        new int[][]{
                                {5, 10, 15}
                        },
                        15
                },

                // Test case 4: Two days
                {
                        new int[][]{
                                {5, 1, 10},
                                {3, 50, 2}
                        },
                        60 // 10 (task 2) + 50 (task 1)
                },

                // Test case 5: Increasing values
                {
                        new int[][]{
                                {1, 2, 3},    // 1, 2, 3
                                {4, 5, 6},   //7, 8, 8
                                {7, 8, 9},    // 15, 16, 17
                                {10, 11, 12} // 27, 28, 28
                        },
                        28 // task 2 -> task 1 -> task 0 -> task 2: 3+5+7+12
                },

                // Test case 6: Edge case - empty input
                {
                        new int[][]{},
                        0
                }
        };

        boolean allPassed = true;
        int testNum = 1;
        for (Object[] testCase : testCases) {
            int[][] points = (int[][]) testCase[0];
            int expected = (int) testCase[1];

            int memoAns = NinjasTraining.getMaxPointsMemo(points);
            int tabAns = NinjasTraining.getMaxPointsTabulation(points);
            int spaceOptAns = NinjasTraining.getMaxPointsSpaceOptimized(points);

            System.out.println("Test Case " + testNum + ":");
            System.out.println("Expected: " + expected);
            System.out.println("Memoization: " + memoAns);
            System.out.println("Tabulation: " + tabAns);
            System.out.println("Space Optimized: " + spaceOptAns);

            boolean passed = (memoAns == expected) && (tabAns == expected) && (spaceOptAns == expected);
            System.out.println(passed ? "✅ Passed\n" : "❌ Failed\n");

            if (!passed) {
                allPassed = false;
            }
            testNum++;
        }

        if (allPassed) {
            System.out.println("🎉 All test cases passed!");
        } else {
            System.out.println("⚠️ Some test cases failed. Please check the output.");
        }
    }
}
