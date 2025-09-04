package dsa.graphs.test;

import dsa.graphs.main.PathWithMinimumEffort;

public class PathWithMinimumEffortTest {
    public static void main(String[] args) {
        PathWithMinimumEffort solver = new PathWithMinimumEffort();
        int passed = 0;

        passed += test(1, solver, new int[][]{
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        }, 2);

        passed += test(2, solver, new int[][]{
                {1, 2, 3},
                {3, 8, 4},
                {5, 3, 5}
        }, 1);

        passed += test(3, solver, new int[][]{
                {1, 2, 1, 1, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 1, 1, 2, 1}
        }, 0);

        passed += test(4, solver, new int[][]{
                {1, 10, 6, 7, 9, 10, 4, 9}
        }, 9);

        passed += test(5, solver, new int[][]{
                {1}
        }, 0);

        passed += test(6, solver, new int[][]{
                {1, 100},
                {1, 1}
        }, 0);

        passed += test(7, solver, new int[][]{
                {1, 2},
                {2, 3}
        }, 1);

        passed += test(8, solver, new int[][]{
                {1, 2, 3},
                {3, 8, 1},
                {2, 3, 1}
        }, 2);

        passed += test(9, solver, new int[][]{
                {8, 3, 6},
                {4, 7, 3},
                {5, 8, 2}
        }, 4);

        passed += test(10, solver, new int[][]{
                {1, 2, 1},
                {1, 100, 1},
                {1, 1, 1}
        }, 0);

        System.out.println("\n✅ Passed " + passed + " out of 10 tests.");
    }

    private static int test(int testNum, PathWithMinimumEffort solver, int[][] grid, int expected) {
        int result = solver.minimumEffortPath(grid);
        boolean passed = result == expected;
        System.out.println("Test " + testNum + ": " + (passed ? "✅ Passed" : "❌ Failed"));
        if (!passed) {
            System.out.println("  Expected: " + expected);
            System.out.println("  Got     : " + result);
        }
        return passed ? 1 : 0;
    }
}
