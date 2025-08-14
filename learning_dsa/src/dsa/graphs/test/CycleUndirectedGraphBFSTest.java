package dsa.graphs.test;

import dsa.graphs.main.CycleUndirectedGraphBFS;

import java.util.ArrayList;
import java.util.List;

public class CycleUndirectedGraphBFSTest {
    public static void main(String[] args) {
        // Each test case is a pair: (number of vertices, adjacency list)
        List<TestCase> testCases = new ArrayList<>();

        // Test Case 1: Simple triangle (cycle)
        testCases.add(new TestCase(3, List.of(
                List.of(1, 2),
                List.of(0, 2),
                List.of(0, 1)
        ), true));

        // Test Case 2: Tree (no cycle)
        testCases.add(new TestCase(5, List.of(
                List.of(1),
                List.of(0, 2, 3),
                List.of(1),
                List.of(1, 4),
                List.of(3)
        ), false));

        // Test Case 3: Single node (no cycle)
        testCases.add(new TestCase(1, List.of(
                List.of()
        ), false));

        // Test Case 4: Disconnected graph with one component having cycle
        testCases.add(new TestCase(6, List.of(
                List.of(1),
                List.of(0, 2),
                List.of(1, 0), // cycle in 0-1-2
                List.of(4),
                List.of(3, 5),
                List.of(4)
        ), true));

        // Test Case 5: Disconnected acyclic graph
        testCases.add(new TestCase(4, List.of(
                List.of(1),
                List.of(0),
                List.of(3),
                List.of(2)
        ), false));

        // Test Case 6: Square cycle (0-1-2-3-0)
        testCases.add(new TestCase(4, List.of(
                List.of(1, 3),
                List.of(0, 2),
                List.of(1, 3),
                List.of(0, 2)
        ), true));

        // Test Case 7: Line graph (no cycle)
        testCases.add(new TestCase(4, List.of(
                List.of(1),
                List.of(0, 2),
                List.of(1, 3),
                List.of(2)
        ), false));

        // Test Case 8: Multiple components, all trees
        testCases.add(new TestCase(6, List.of(
                List.of(1),
                List.of(0),
                List.of(3),
                List.of(2),
                List.of(5),
                List.of(4)
        ), false));

        // Test Case 9: Graph with self-loop (should be considered a cycle)
        testCases.add(new TestCase(3, List.of(
                List.of(0), // self-loop
                List.of(2),
                List.of(1)
        ), true));

        // Test Case 10: Star shaped (no cycle)
        testCases.add(new TestCase(5, List.of(
                List.of(1, 2, 3, 4),
                List.of(0),
                List.of(0),
                List.of(0),
                List.of(0)
        ), false));

        // Run all test cases
        int testNum = 1;
        for (TestCase tc : testCases) {
            boolean result = CycleUndirectedGraphBFS.isCycleUndirectedGraphBFS(tc.v, tc.adj);
            System.out.println("Test Case " + testNum + ": " + (result == tc.expected ? "Passed" : "Failed"));
            testNum++;
        }
    }
}

class TestCase {
    int v;
    List<List<Integer>> adj;
    boolean expected;

    TestCase(int v, List<List<Integer>> adj, boolean expected) {
        this.v = v;
        this.adj = adj;
        this.expected = expected;
    }
}
