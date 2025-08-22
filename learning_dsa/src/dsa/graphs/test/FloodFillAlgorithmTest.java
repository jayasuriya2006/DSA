package dsa.graphs.test;

import dsa.graphs.main.FloodFillAlgorithm;

import java.util.Arrays;

public class FloodFillAlgorithmTest {
    public static void main(String[] args) {
        int passed = 0;
        int totalTests = 10;

        FloodFillAlgorithm algo = new FloodFillAlgorithm();

        // Test 1: Simple fill
        int[][] image1 = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int[][] expected1 = {
                {2, 2, 2},
                {2, 2, 0},
                {2, 0, 1}
        };
        passed += test("Test 1", image1, 1, 1, 2, expected1, algo);

        // Test 2: No change (old color = new color)
        int[][] image2 = {
                {0, 0, 0},
                {0, 1, 1}
        };
        int[][] expected2 = {
                {0, 0, 0},
                {0, 1, 1}
        };
        passed += test("Test 2", image2, 1, 1, 1, expected2, algo);

        // Test 3: Edge start
        int[][] image3 = {
                {0, 0, 0},
                {0, 1, 1}
        };
        int[][] expected3 = {
                {2, 2, 2},
                {2, 1, 1}
        };
        passed += test("Test 3", image3, 0, 0, 2, expected3, algo);

        // Test 4: Single pixel image
        int[][] image4 = {
                {1}
        };
        int[][] expected4 = {
                {2}
        };
        passed += test("Test 4", image4, 0, 0, 2, expected4, algo);

        // Test 5: All same color
        int[][] image5 = {
                {1, 1},
                {1, 1}
        };
        int[][] expected5 = {
                {2, 2},
                {2, 2}
        };
        passed += test("Test 5", image5, 0, 0, 2, expected5, algo);

        // Test 6: Diagonal shouldn't be filled
        int[][] image6 = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };
        int[][] expected6 = {
                {2, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };
        passed += test("Test 6", image6, 0, 0, 2, expected6, algo);

        // Test 7: Fill bottom-right
        int[][] image7 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 0}
        };
        int[][] expected7 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 2}
        };
        passed += test("Test 7", image7, 2, 2, 2, expected7, algo);

        // Test 8: Multiple color regions
        int[][] image8 = {
                {1, 2, 3},
                {1, 1, 3},
                {3, 3, 3}
        };
        int[][] expected8 = {
                {9, 2, 3},
                {9, 9, 3},
                {3, 3, 3}
        };
        passed += test("Test 8", image8, 0, 0, 9, expected8, algo);

        // Test 9: Touching borders
        int[][] image9 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] expected9 = {
                {2, 2, 2},
                {2, 0, 2},
                {2, 2, 2}
        };
        passed += test("Test 9", image9, 0, 0, 2, expected9, algo);

        // Test 10: Big change area
        int[][] image10 = {
                {0, 0, 0},
                {0, 0, 0}
        };
        int[][] expected10 = {
                {1, 1, 1},
                {1, 1, 1}
        };
        passed += test("Test 10", image10, 0, 0, 1, expected10, algo);

        System.out.println("\nSummary: Passed " + passed + "/" + totalTests);
    }

    private static int test(String testName, int[][] image, int sr, int sc, int color,
                            int[][] expected, FloodFillAlgorithm algo) {
        int[][] result = algo.floodFill(image, sr, sc, color);
        if (deepEquals(result, expected)) {
            System.out.println("✅ " + testName + " passed");
            return 1;
        } else {
            System.out.println("❌ " + testName + " failed");
            System.out.println("   Expected: " + Arrays.deepToString(expected));
            System.out.println("   Actual:   " + Arrays.deepToString(result));
            return 0;
        }
    }

    private static boolean deepEquals(int[][] a, int[][] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!Arrays.equals(a[i], b[i])) return false;
        }
        return true;
    }
}
