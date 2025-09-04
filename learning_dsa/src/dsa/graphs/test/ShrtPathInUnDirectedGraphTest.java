package dsa.graphs.test;

import dsa.graphs.main.ShrtPathInUnDirectedGraph;

import java.util.Arrays;

public class ShrtPathInUnDirectedGraphTest {
    public static void main(String[] args) {
        int passed = 0, total = 5;

        passed += runTest(new int[][]{
                {0, 1, 0, 0},
                {1, 0, 1, 1},
                {0, 1, 0, 1},
                {0, 1, 1, 0}
        }, 0, new int[]{0, 1, 2, 2}, "Test1");

        passed += runTest(new int[][]{
                {0, 0, 0},
                {0, 0, 1},
                {0, 1, 0}
        }, 0, new int[]{0, -1, -1}, "Test2 - disconnected");

        passed += runTest(new int[][]{
                {0, 1, 1},
                {1, 0, 0},
                {1, 0, 0}
        }, 1, new int[]{1, 0, 2}, "Test3");

        passed += runTest(new int[][]{
                {0}
        }, 0, new int[]{0}, "Test4 - single node");

        passed += runTest(new int[][]{
                {0, 1, 0, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 0, 1, 1, 0}
        }, 2, new int[]{2, 1, 0, 2, 1}, "Test5");

        System.out.println("\nPassed " + passed + " out of " + total + " tests.");
    }

    private static int runTest(int[][] graph, int startNode, int[] expected, String testName) {
        int[] result = ShrtPathInUnDirectedGraph.getMinDistance(graph, startNode);
        if (Arrays.equals(result, expected)) {
            System.out.println(testName + ": ✅");
            return 1;
        } else {
            System.out.println(testName + ": ❌");
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Got     : " + Arrays.toString(result));
            return 0;
        }
    }
}
