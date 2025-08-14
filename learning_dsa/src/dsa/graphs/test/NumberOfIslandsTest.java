package dsa.graphs.test;

import dsa.graphs.main.NumberOfIslands;

public class NumberOfIslandsTest {
    public static void main(String[] args) {
        int passed = 0;
        int totalTests = 10;

        // Test 1: One island
        char[][] grid1 = {
                {'1', '1', '0', '0'},
                {'1', '1', '0', '0'},
                {'0', '0', '1', '0'},
                {'0', '0', '0', '1'}
        };
        passed += test("Test 1", grid1, 3);

        // Test 2: All water
        char[][] grid2 = {
                {'0', '0'},
                {'0', '0'}
        };
        passed += test("Test 2", grid2, 0);

        // Test 3: All land (one big island)
        char[][] grid3 = {
                {'1', '1'},
                {'1', '1'}
        };
        passed += test("Test 3", grid3, 1);

        // Test 4: Vertical islands
        char[][] grid4 = {
                {'1', '0'},
                {'1', '0'},
                {'1', '0'},
                {'1', '0'}
        };
        passed += test("Test 4", grid4, 1);

        // Test 5: Horizontal islands
        char[][] grid5 = {
                {'1', '1', '0', '0', '1', '1'}
        };
        passed += test("Test 5", grid5, 2);

        // Test 6: Checkerboard islands
        char[][] grid6 = {
                {'1', '0', '1'},
                {'0', '1', '0'},
                {'1', '0', '1'}
        };
        passed += test("Test 6", grid6, 5);

        // Test 7: Empty grid
        char[][] grid7 = new char[0][0];
        passed += test("Test 7", grid7, 0);

        // Test 8: One land cell
        char[][] grid8 = {
                {'1'}
        };
        passed += test("Test 8", grid8, 1);

        // Test 9: One water cell
        char[][] grid9 = {
                {'0'}
        };
        passed += test("Test 9", grid9, 0);

        // Test 10: L-shaped island
        char[][] grid10 = {
                {'1', '0', '0'},
                {'1', '1', '0'},
                {'0', '1', '0'}
        };
        passed += test("Test 10", grid10, 1);

        System.out.println("\nSummary: Passed " + passed + "/" + totalTests);
    }

    private static int test(String testName, char[][] grid, int expected) {
        int actual = 0;
        try {
            actual = NumberOfIslands.numIslands(grid);
        } catch (Exception e) {
            System.out.println("❌ " + testName + " failed with exception: " + e.getMessage());
            return 0;
        }

        if (actual == expected) {
            System.out.println("✅ " + testName + " passed");
            return 1;
        } else {
            System.out.println("❌ " + testName + " failed");
            System.out.println("   Expected: " + expected);
            System.out.println("   Actual:   " + actual);
            return 0;
        }
    }
}
