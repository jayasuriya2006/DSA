package dsa.dp.test;

import dsa.dp.main.GridUniquePaths;

public class GridUniquePathsTest {
    public static void main(String[] args) {
        Object[][] testCases = new Object[][] {
                {2, 2, 2},    // Right→Down or Down→Right
                {3, 3, 6},    // 6 paths in 3x3 grid
                {1, 5, 1},    // Only one way (right-right-right-right)
                {5, 1, 1},    // Only one way (down-down-down-down)
                {3, 7, 28}    // Larger grid
        };

        boolean allPassed = true;
        int testNum = 1;

        for (Object[] test : testCases) {
            int n = (int) test[0];
            int m = (int) test[1];
            int expected = (int) test[2];

            int memo = GridUniquePaths.getUniquePathCountMemo(n, m);
            int tab = GridUniquePaths.getUniquePathCountTabulation(n, m);
            int spaceOpt = GridUniquePaths.getUniquePathCountSpaceOptimized(n, m);

            boolean passed = memo == expected && tab == expected && spaceOpt == expected;

            System.out.printf("Test Case %d: (%dx%d Grid)\n", testNum, n, m);
            System.out.printf("Expected: %d, Memo: %d, Tab: %d, SpaceOpt: %d\n", expected, memo, tab, spaceOpt);
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
