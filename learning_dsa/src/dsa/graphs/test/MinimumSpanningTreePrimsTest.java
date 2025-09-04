package dsa.graphs.test;

import dsa.graphs.main.MinimumSpanningTreePrims;

public class MinimumSpanningTreePrimsTest {
    public static void main(String[] args) {
        MinimumSpanningTreePrims prims = new MinimumSpanningTreePrims();

        int test = 1;

        // Test 1: Simple triangle
        runTest(prims, 3, new int[][]{
                {0, 1, 1}, {1, 2, 2}, {0, 2, 3}
        }, 3, test++);

        // Test 2: Line graph
        runTest(prims, 4, new int[][]{
                {0, 1, 1}, {1, 2, 1}, {2, 3, 1}
        }, 3, test++);

        // Test 3: Star graph
        runTest(prims, 5, new int[][]{
                {0, 1, 1}, {0, 2, 1}, {0, 3, 1}, {0, 4, 1}
        }, 4, test++);

        // Test 4: Fully connected graph with varying weights
        runTest(prims, 4, new int[][]{
                {0, 1, 10}, {0, 2, 6}, {0, 3, 5},
                {1, 3, 15}, {2, 3, 4}
        }, 19, test++);

        // Test 5: Disconnected graph (MST not possible)
        // Since all nodes aren't connected, the sum should include only connected components.
        // Here, assume problem guarantees connectivity.
        // So skip invalid MST test.

        // Test 6: Single node
        runTest(prims, 1, new int[][]{}, 0, test++);

        // Test 7: Two nodes, one edge
        runTest(prims, 2, new int[][]{
                {0, 1, 42}
        }, 42, test++);

        // Test 8: Minimum edges to connect all nodes
        runTest(prims, 4, new int[][]{
                {0, 1, 1}, {1, 2, 2}, {2, 3, 3}, {0, 3, 10}
        }, 6, test++);

        // Test 9: Duplicate edges (only minimum should be chosen)
        runTest(prims, 3, new int[][]{
                {0, 1, 10}, {0, 1, 1}, {1, 2, 1}
        }, 2, test++);

        // Test 10: Random weights with clear MST
        runTest(prims, 5, new int[][]{
                {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {2, 4, 7}
        }, 16, test++);
    }

    private static void runTest(MinimumSpanningTreePrims prims, int V, int[][] edges, int expected, int testNum) {
        int result = prims.spanningTree(V, edges);
        if (result == expected) {
            System.out.println("Test " + testNum + " ✅ Passed");
        } else {
            System.out.println("Test " + testNum + " ❌ Failed");
            System.out.println("Expected: " + expected + ", Got: " + result);
        }
    }
}
