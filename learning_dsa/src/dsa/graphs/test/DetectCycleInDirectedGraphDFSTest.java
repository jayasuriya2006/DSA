package dsa.graphs.test;

import dsa.graphs.main.DetectCycleInDirectedGraphDFS;

public class DetectCycleInDirectedGraphDFSTest {
    public static void main(String[] args) {
        test(new int[][]{{0, 1}, {1, 2}, {2, 0}}, 3, true, 1);  // Cycle
        test(new int[][]{{0, 1}, {1, 2}}, 3, false, 2);         // No Cycle
        test(new int[][]{}, 0, false, 3);                       // Empty Graph
        test(new int[][]{{0, 0}}, 1, true, 4);                  // Self-loop
        test(new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 1}}, 4, true, 5); // Cycle
        test(new int[][]{{0, 1}, {2, 3}}, 4, false, 6);         // Disconnected No Cycle
        test(new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, 5, false, 7); // No Cycle
        test(new int[][]{{0, 1}, {1, 2}, {2, 0}, {3, 4}}, 5, true, 8);  // Partial cycle
        test(new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 1}, {4, 5}}, 6, true, 9); // Cycle in component
        test(new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 2}}, 5, true, 10); // Long cycle
    }

    private static void test(int[][] edges, int v, boolean expected, int testCaseNumber) {
        boolean result = DetectCycleInDirectedGraphDFS.isDirectedGraphHasCycleDFS(v, edges);
        if (result == expected) {
            System.out.println("✅ Test case " + testCaseNumber + " passed");
        } else {
            System.out.println("❌ Test case " + testCaseNumber + " failed. Expected " + expected + " but got " + result);
        }
    }
}
