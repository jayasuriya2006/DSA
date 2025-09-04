package dsa.graphs.test;

import dsa.graphs.main.DtctCycleInDirectedGraphTopo;

public class DtctCycleInDirectedGraphTopoTest {
    public static void main(String[] args) {
        test(new int[][]{{0, 1}, {1, 2}, {2, 0}}, 3, true, 1);     // Cycle
        test(new int[][]{{0, 1}, {1, 2}, {2, 3}}, 4, false, 2);    // No Cycle
        test(new int[][]{}, 0, false, 3);                          // Empty graph
        test(new int[][]{{0, 0}}, 1, true, 4);                     // Self-loop (cycle)
        test(new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 1}}, 4, true, 5);  // Back edge (cycle)
        test(new int[][]{{0, 1}, {2, 3}}, 4, false, 6);            // Disconnected, no cycle
        test(new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, 5, false, 7); // Linear, no cycle
        test(new int[][]{{0, 1}, {1, 2}, {2, 0}, {3, 4}}, 5, true, 8);  // One component has a cycle
        test(new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 1}, {4, 5}}, 6, true, 9); // Cycle + isolated edge
        test(new int[][]{{0, 1}, {2, 0}, {1, 3}}, 4, false, 10);   // Valid DAG
    }

    private static void test(int[][] edges, int v, boolean expected, int testCaseNumber) {
        boolean result = DtctCycleInDirectedGraphTopo.isDirectedGraphHasCycleDFS(edges, v);
        if (result == expected) {
            System.out.println("✅ Test case " + testCaseNumber + " passed");
        } else {
            System.out.println("❌ Test case " + testCaseNumber + " failed. Expected " + expected + ", but got " + result);
        }
    }
}
