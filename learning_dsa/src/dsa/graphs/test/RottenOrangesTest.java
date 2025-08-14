package dsa.graphs.test;

import dsa.graphs.main.RottenOranges;

import java.util.Arrays;

public class RottenOrangesTest {
    public static void main(String[] args) {
        int passed = 0;
        int totalTests = 10;

        RottenOranges solver = new RottenOranges();

        // Test 1: Normal case
        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        passed += test("Test 1", grid1, 4, solver);

        // Test 2: All already rotten
        int[][] grid2 = {
                {2, 2},
                {2, 2}
        };
        passed += test("Test 2", grid2, 0, solver);

        // Test 3: Impossible case
        int[][] grid3 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        passed += test("Test 3", grid3, -1, solver);

        // Test 4: Single fresh, unreachable
        int[][] grid4 = {
                {0, 2},
                {0, 1}
        };
        passed += test("Test 4", grid4, 1, solver);

        // Test 5: Single rotten and one fresh reachable
        int[][] grid5 = {
                {2, 1}
        };
        passed += test("Test 5", grid5, 1, solver);

        // Test 6: Empty grid
        int[][] grid6 = new int[0][0];
        passed += test("Test 6", grid6, 0, solver);

        // Test 7: One fresh, one rotten diagonally (unreachable)
        int[][] grid7 = {
                {1, 0},
                {0, 2}
        };
        passed += test("Test 7", grid7, -1, solver);

        // Test 8: Only fresh oranges
        int[][] grid8 = {
                {1, 1},
                {1, 1}
        };
        passed += test("Test 8", grid8, -1, solver);

        // Test 9: Only one orange, already rotten
        int[][] grid9 = {
                {2}
        };
        passed += test("Test 9", grid9, 0, solver);

        // Test 10: Only one orange, fresh
        int[][] grid10 = {
                {1}
        };
        passed += test("Test 10", grid10, -1, solver);

        System.out.println("\nSummary: Passed " + passed + " out of " + totalTests + " tests.");
    }

    private static int test(String testName, int[][] grid, int expected, RottenOranges solver) {
        try {
            // Clone grid to avoid mutation during test
            int[][] gridCopy = deepCopy(grid);
            int result = solver.orangesRotting(gridCopy);
            if (result == expected) {
                System.out.println("✅ " + testName + " passed");
                return 1;
            } else {
                System.out.println("❌ " + testName + " failed");
                System.out.println("   Expected: " + expected);
                System.out.println("   Actual:   " + result);
                return 0;
            }
        } catch (Exception e) {
            System.out.println("❌ " + testName + " threw an exception: " + e.getMessage());
            return 0;
        }
    }

    private static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copy;
    }
}
