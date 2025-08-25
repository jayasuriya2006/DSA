package dsa.graphs.test;

import dsa.graphs.main.PrintShortestPath;

public class PrintShortestPathTest {
    public static void main(String[] args) {
        int passed = 0;

        // Test 1: Simple direct path
        passed += test(1, 3, 0, 2, new int[][]{
                {0, 1, 1},
                {1, 2, 2}
        }, "0 -> 1 -> 2");

        // Test 2: Shorter alternate path
        passed += test(2, 3, 0, 2, new int[][]{
                {0, 1, 1},
                {1, 2, 10},
                {0, 2, 2}
        }, "0 -> 2");

        // Test 3: No path
        passed += test(3, 4, 0, 3, new int[][]{
                {0, 1, 1},
                {1, 2, 1}
        }, "No path");

        // Test 4: Source equals destination
        passed += test(4, 3, 1, 1, new int[][]{
                {0, 1, 5},
                {1, 2, 10}
        }, "1");

        // Test 5: Longer chain
        passed += test(5, 5, 0, 4, new int[][]{
                {0, 1, 2},
                {1, 2, 2},
                {2, 3, 2},
                {3, 4, 2}
        }, "0 -> 1 -> 2 -> 3 -> 4");

        // Test 6: Multiple same-cost paths, prefer first found
        passed += test(6, 4, 0, 3, new int[][]{
                {0, 1, 1},
                {1, 3, 2},
                {0, 2, 1},
                {2, 3, 2}
        }, "0 -> 1 -> 3");

        // Test 7: Graph with cycle
        passed += test(7, 4, 0, 3, new int[][]{
                {0, 1, 1},
                {1, 2, 1},
                {2, 0, 1},
                {2, 3, 1}
        }, "0 -> 1 -> 2 -> 3");

        // Test 8: No edges at all
        passed += test(8, 3, 0, 2, new int[][]{}, "No path");

        // Test 9: Multiple digits nodes
        passed += test(9, 12, 10, 11, new int[][]{
                {10, 11, 5}
        }, "10 -> 11");

        // Test 10: Complex path with detour
        passed += test(10, 6, 0, 5, new int[][]{
                {0, 1, 1},
                {1, 2, 1},
                {2, 3, 1},
                {3, 4, 1},
                {4, 5, 1},
                {0, 5, 10}
        }, "0 -> 1 -> 2 -> 3 -> 4 -> 5");

        System.out.println("\n✅ Passed " + passed + " out of 10 tests.");
    }

    private static int test(int testNum, int v, int src, int des, int[][] edges, String expected) {
        String result = PrintShortestPath.getShortest(v, src, des, edges);
        boolean passed = expected.equals(result);
        System.out.println("Test " + testNum + ": " + (passed ? "✅ Passed" : "❌ Failed"));
        if (!passed) {
            System.out.println("  Expected: " + expected);
            System.out.println("  Got     : " + result);
        }
        return passed ? 1 : 0;
    }
}
