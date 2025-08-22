package dsa.graphs.test;

import dsa.graphs.main.GraphsTraversals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GraphsTraversalsTest {
    public static void main(String[] args) {
        int passCount = 0;
        int totalTests = 10 * 2; // 10 tests, each with BFS and DFS

        // Test 1: Simple linear graph
        List<List<Integer>> adj1 = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(0, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2)
        );
        testBFS("Test 1 - BFS", 4, adj1, Arrays.asList(
                Arrays.asList(0),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3)
        ));
        testDFS("Test 1 - DFS", 4, adj1, Arrays.asList(0, 1, 2, 3));

        // Test 2: Disconnected graph
        List<List<Integer>> adj2 = Arrays.asList(
                new ArrayList<>(),
                Arrays.asList(2),
                Arrays.asList(1)
        );
        testBFS("Test 2 - BFS", 3, adj2, List.of(List.of(0)));
        testDFS("Test 2 - DFS", 3, adj2, List.of(0));

        // Test 3: Graph with cycle
        List<List<Integer>> adj3 = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(0, 2),
                Arrays.asList(0, 1)
        );
        testBFS("Test 3 - BFS", 3, adj3, List.of(
                List.of(0),
                List.of(1, 2)
        ));
        testDFS("Test 3 - DFS", 3, adj3, List.of(0, 1, 2));

        // Test 4: Tree structure
        List<List<Integer>> adj4 = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );
        testBFS("Test 4 - BFS", 5, adj4, List.of(
                List.of(0),
                List.of(1, 2),
                List.of(3, 4)
        ));
        testDFS("Test 4 - DFS", 5, adj4, List.of(0, 1, 3, 4, 2));

        // Test 5: Self-loop
        List<List<Integer>> adj5 = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(0)
        );
        testBFS("Test 5 - BFS", 2, adj5, List.of(
                List.of(0),
                List.of(1)
        ));
        testDFS("Test 5 - DFS", 2, adj5, List.of(0, 1));

        // Test 6: Matrix graph
        int[][] matrix6 = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };
        testBFSMatrix("Test 6 - BFS Matrix", 3, matrix6, List.of(
                List.of(0),
                List.of(1),
                List.of(2)
        ));
        testDFSMatrix("Test 6 - DFS Matrix", 3, matrix6, List.of(0, 1, 2));

        // Test 7: Single node
        List<List<Integer>> adj7 = List.of(new ArrayList<>());
        testBFS("Test 7 - BFS", 1, adj7, List.of(List.of(0)));
        testDFS("Test 7 - DFS", 1, adj7, List.of(0));

        // Test 8: Fully connected 3-node graph
        List<List<Integer>> adj8 = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(0, 2),
                Arrays.asList(0, 1)
        );
        testBFS("Test 8 - BFS", 3, adj8, List.of(
                List.of(0),
                List.of(1, 2)
        ));
        testDFS("Test 8 - DFS", 3, adj8, List.of(0, 1, 2));

        // Test 9: Star graph
        List<List<Integer>> adj9 = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(0),
                Arrays.asList(0),
                Arrays.asList(0),
                Arrays.asList(0)
        );
        testBFS("Test 9 - BFS", 5, adj9, List.of(
                List.of(0),
                List.of(1, 2, 3, 4)
        ));
        testDFS("Test 9 - DFS", 5, adj9, List.of(0, 1, 2, 3, 4)); // will re-visit 0 due to undirected edges

        // Test 10: Line graph matrix
        int[][] matrix10 = {
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0}
        };
        testBFSMatrix("Test 10 - BFS Matrix", 5, matrix10, List.of(
                List.of(0),
                List.of(1),
                List.of(2),
                List.of(3),
                List.of(4)
        ));
        testDFSMatrix("Test 10 - DFS Matrix", 5, matrix10, List.of(0, 1, 2, 3, 4));
    }

    // --- Test helpers below ---
    private static void testBFS(String testName, int v, List<List<Integer>> adj, List<List<Integer>> expected) {
        List<List<Integer>> actual = GraphsTraversals.bfsFromAdjList(v, adj);
        printTestResult(testName, expected, actual);
    }

    private static void testDFS(String testName, int v, List<List<Integer>> adj, List<Integer> expected) {
        List<Integer> actual = GraphsTraversals.dfsFromAdjList(v, adj);
        printTestResult(testName, expected, actual);
    }

    private static void testBFSMatrix(String testName, int v, int[][] matrix, List<List<Integer>> expected) {
        List<List<Integer>> actual = GraphsTraversals.bfsFromAdjMatrix(v, matrix);
        printTestResult(testName, expected, actual);
    }

    private static void testDFSMatrix(String testName, int v, int[][] matrix, List<Integer> expected) {
        List<Integer> actual = GraphsTraversals.dfsFromAdjMatrix(v, matrix);
        printTestResult(testName, expected, actual);
    }

    private static <T> void printTestResult(String testName, T expected, T actual) {
        if (Objects.equals(expected, actual)) {
            System.out.println("✅ " + testName + " passed");
        } else {
            System.out.println("❌ " + testName + " failed");
            System.out.println("   Expected: " + expected);
            System.out.println("   Actual:   " + actual);
        }
    }
}
