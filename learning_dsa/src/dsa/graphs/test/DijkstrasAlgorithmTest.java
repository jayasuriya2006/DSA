package dsa.graphs.test;

import dsa.graphs.main.DijkstrasAlgorithm;

import java.util.Arrays;

public class DijkstrasAlgorithmTest {
    public static void main(String[] args) {
        int passed = 0;

        // Test 1: Simple triangle
        passed += test(1, 3, 0, new int[][]{
                {0, 1, 1},
                {1, 2, 2},
                {0, 2, 4}
        }, new int[]{0, 1, 3});

        // Test 2: Disconnected nodes
        passed += test(2, 4, 0, new int[][]{
                {0, 1, 1},
                {1, 2, 1}
        }, new int[]{0, 1, 2, Integer.MAX_VALUE});

        // Test 3: Multiple paths
        passed += test(3, 4, 0, new int[][]{
                {0, 1, 2},
                {0, 2, 1},
                {2, 1, 1},
                {1, 3, 1},
                {2, 3, 5}
        }, new int[]{0, 2, 1, 3});

        // Test 4: Single node
        passed += test(4, 1, 0, new int[][]{}, new int[]{0});

        // Test 5: Negative weights (should still work if no negative cycles)
        passed += test(5, 3, 0, new int[][]{
                {0, 1, -2},
                {1, 2, -1}
        }, new int[]{0, -2, -3}); // Dijkstra is not reliable with negative weights; but code doesn't block it

        // Test 6: Graph with cycle
        passed += test(6, 4, 0, new int[][]{
                {0, 1, 1},
                {1, 2, 2},
                {2, 0, 3},
                {2, 3, 4}
        }, new int[]{0, 1, 3, 7});

        // Test 7: Multiple equal shortest paths
        passed += test(7, 5, 0, new int[][]{
                {0, 1, 1},
                {0, 2, 1},
                {1, 3, 1},
                {2, 3, 1},
                {3, 4, 1}
        }, new int[]{0, 1, 1, 2, 3});

        // Test 8: Long linear graph
        passed += test(8, 6, 0, new int[][]{
                {0, 1, 2},
                {1, 2, 2},
                {2, 3, 2},
                {3, 4, 2},
                {4, 5, 2}
        }, new int[]{0, 2, 4, 6, 8, 10});

        // Test 9: Star graph
        passed += test(9, 6, 0, new int[][]{
                {0, 1, 10},
                {0, 2, 20},
                {0, 3, 30},
                {0, 4, 40},
                {0, 5, 50}
        }, new int[]{0, 10, 20, 30, 40, 50});

        // Test 10: No edges at all
        passed += test(10, 4, 0, new int[][]{}, new int[]{0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE});

        System.out.println("\n✅ Passed " + passed + " out of 10 tests.");
    }

    private static int test(int testCaseNumber, int v, int src, int[][] edges, int[] expected) {
        int[] result = DijkstrasAlgorithm.getMinDistance(v, src, edges);
        boolean passed = Arrays.equals(result, expected);
        System.out.println("Test " + testCaseNumber + ": " + (passed ? "✅ Passed" : "❌ Failed"));
        if (!passed) {
            System.out.println("  Expected: " + Arrays.toString(expected));
            System.out.println("  Got     : " + Arrays.toString(result));
        }
        return passed ? 1 : 0;
    }
}
