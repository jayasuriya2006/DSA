package dsa.graphs.test;

import dsa.graphs.main.FloydWarshall;

import java.util.Arrays;

public class FloydWarshallTest {
    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        int testCount = 1;

        // Test 1: Simple 3-node graph
        runTest(fw, new int[][]{
                {0, 5, 100000000},
                {100000000, 0, 3},
                {100000000, 100000000, 0}
        }, new int[][]{
                {0, 5, 8},
                {100000000, 0, 3},
                {100000000, 100000000, 0}
        }, testCount++);

        // Test 2: Graph with zero weight edges
        runTest(fw, new int[][]{
                {0, 0, 100000000},
                {100000000, 0, 0},
                {0, 100000000, 0}
        }, new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        }, testCount++);

        // Test 3: All disconnected except diagonal
        runTest(fw, new int[][]{
                {0, 100000000, 100000000},
                {100000000, 0, 100000000},
                {100000000, 100000000, 0}
        }, new int[][]{
                {0, 100000000, 100000000},
                {100000000, 0, 100000000},
                {100000000, 100000000, 0}
        }, testCount++);

        // Test 4: Complete graph with equal weights
        runTest(fw, new int[][]{
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
        }, new int[][]{
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
        }, testCount++);

        // Test 5: Graph with negative edge but no cycle
        runTest(fw, new int[][]{
                {0, 1, 100000000},
                {100000000, 0, -1},
                {4, 100000000, 0}
        }, new int[][]{
                {0, 1, 0},
                {3, 0, -1},
                {4, 5, 0}
        }, testCount++);

        // Test 6: Graph with negative cycle
        runTest(fw, new int[][]{
                {0, 1, 100000000},
                {100000000, 0, -1},
                {-1, 100000000, 0}
        }, new int[][]{
                {-1}
        }, testCount++);

        // Test 7: 1 node
        runTest(fw, new int[][]{
                {0}
        }, new int[][]{
                {0}
        }, testCount++);

        // Test 8: 2 nodes, no edge
        runTest(fw, new int[][]{
                {0, 100000000},
                {100000000, 0}
        }, new int[][]{
                {0, 100000000},
                {100000000, 0}
        }, testCount++);

        // Test 9: 2 nodes, one-way edge
        runTest(fw, new int[][]{
                {0, 3},
                {100000000, 0}
        }, new int[][]{
                {0, 3},
                {100000000, 0}
        }, testCount++);

        // Test 10: 4 nodes, mixed edges
        runTest(fw, new int[][]{
                {0, 3, 100000000, 5},
                {2, 0, 100000000, 4},
                {100000000, 1, 0, 100000000},
                {100000000, 100000000, 2, 0}
        }, new int[][]{
                {0, 3, 7, 5},
                {2, 0, 6, 4},
                {3, 1, 0, 5},
                {5, 3, 2, 0}
        }, testCount++);
    }

    private static void runTest(FloydWarshall fw, int[][] input, int[][] expected, int testNum) {
        int[][] result = fw.floydWarshall(cloneMatrix(input));

        if (Arrays.deepEquals(result, expected)) {
            System.out.println("Test " + testNum + " ✅ Passed");
        } else {
            System.out.println("Test " + testNum + " ❌ Failed");
            System.out.println("Expected:");
            printMatrix(expected);
            System.out.println("Got:");
            printMatrix(result);
        }
    }

    private static int[][] cloneMatrix(int[][] matrix) {
        int[][] copy = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            copy[i] = matrix[i].clone();
        }
        return copy;
    }

    private static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }
}
