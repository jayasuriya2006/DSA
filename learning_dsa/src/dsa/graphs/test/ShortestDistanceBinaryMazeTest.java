package dsa.graphs.test;

import dsa.graphs.main.ShortestDistanceBinaryMaze;

public class ShortestDistanceBinaryMazeTest {
    public static void main(String[] args) {
        ShortestDistanceBinaryMaze solver = new ShortestDistanceBinaryMaze();
        int passed = 0;

        passed += test(1, solver, new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        }, 4);  // Expected: 5

        passed += test(2, solver, new int[][]{
                {0, 1},
                {1, 0}
        }, 2);  // Diagonal path

        passed += test(3, solver, new int[][]{
                {1, 0},
                {0, 0}
        }, -1);  // Start is blocked

        passed += test(4, solver, new int[][]{
                {0, 0},
                {0, 1}
        }, -1);  // End is blocked

        passed += test(5, solver, new int[][]{
                {0}
        }, 1);  // Single cell

        passed += test(6, solver, new int[][]{
                {0, 1, 0},
                {0, 1, 0},
                {0, 0, 0}
        }, 4);  // Forced detour around wall

        passed += test(7, solver, new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }, 4);  // Can go around

        passed += test(8, solver, new int[][]{
                {0, 1, 1},
                {0, 1, 1},
                {0, 0, 0}
        }, 4);  // Longer zigzag path

        passed += test(9, solver, new int[][]{
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        }, -1);  // No path

        passed += test(10, solver, new int[][]{
                {0, 0, 0, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 0}
        }, 6);  // Only right edge is open

        System.out.println("\n✅ Passed " + passed + " out of 10 tests.");
    }

    private static int test(int testNum, ShortestDistanceBinaryMaze solver, int[][] grid, int expected) {
        int result = solver.shortestPathBinaryMatrix(grid);
        boolean passed = (result == expected);
        System.out.println("Test " + testNum + ": " + (passed ? "✅ Passed" : "❌ Failed"));
        if (!passed) {
            System.out.println("  Expected: " + expected);
            System.out.println("  Got     : " + result);
        }
        return passed ? 1 : 0;
    }
}
