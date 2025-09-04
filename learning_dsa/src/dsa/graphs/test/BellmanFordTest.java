package dsa.graphs.test;

import dsa.graphs.main.BellmanFord;

import java.util.Arrays;

public class BellmanFordTest {
    public static void main(String[] args) {
        BellmanFord bf = new BellmanFord();

        int testCount = 1;

        // Test Case 1: Simple graph
        runTest(bf, 5, new int[][]{
                {0, 1, -1}, {0, 2, 4}, {1, 2, 3},
                {1, 3, 2}, {1, 4, 2}, {3, 2, 5},
                {3, 1, 1}, {4, 3, -3}
        }, 0, new int[]{0, -1, 2, -2, 1}, testCount++);

        // Test Case 2: Single node
        runTest(bf, 1, new int[][]{}, 0, new int[]{0}, testCount++);

        // Test Case 3: No edges
        runTest(bf, 4, new int[][]{}, 2, new int[]{100000000, 100000000, 0, 100000000}, testCount++);

        // Test Case 4: Disconnected graph
        runTest(bf, 3, new int[][]{
                {0, 1, 5}
        }, 0, new int[]{0, 5, 100000000}, testCount++);

        // Test Case 5: Graph with negative cycle
        runTest(bf, 3, new int[][]{
                {0, 1, 1}, {1, 2, -1}, {2, 0, -1}
        }, 0, new int[]{-1}, testCount++);

        // Test Case 6: Graph with zero-weight edges
        runTest(bf, 4, new int[][]{
                {0, 1, 0}, {1, 2, 0}, {2, 3, 0}
        }, 0, new int[]{0, 0, 0, 0}, testCount++);

        // Test Case 7: Long chain
        runTest(bf, 6, new int[][]{
                {0, 1, 1}, {1, 2, 1}, {2, 3, 1}, {3, 4, 1}, {4, 5, 1}
        }, 0, new int[]{0, 1, 2, 3, 4, 5}, testCount++);

        // Test Case 8: Edges with same source and destination
        runTest(bf, 3, new int[][]{
                {0, 0, 0}, {0, 1, 1}, {1, 2, 2}
        }, 0, new int[]{0, 1, 3}, testCount++);

        // Test Case 9: Multiple edges between same nodes (only lowest weight should be considered)
        runTest(bf, 3, new int[][]{
                {0, 1, 10}, {0, 1, 5}, {1, 2, 1}
        }, 0, new int[]{0, 5, 6}, testCount++);

        // Test Case 10: All edges are negative weights but no negative cycle
        runTest(bf, 4, new int[][]{
                {0, 1, -1}, {1, 2, -2}, {2, 3, -3}
        }, 0, new int[]{0, -1, -3, -6}, testCount++);
    }

    private static void runTest(BellmanFord bf, int V, int[][] edges, int src, int[] expected, int testNum) {
        int[] result = bf.bellmanFord(V, edges, src);
        if (Arrays.equals(result, expected)) {
            System.out.println("Test " + testNum + " ✅ Passed");
        } else {
            System.out.println("Test " + testNum + " ❌ Failed");
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Got     : " + Arrays.toString(result));
        }
    }
}
