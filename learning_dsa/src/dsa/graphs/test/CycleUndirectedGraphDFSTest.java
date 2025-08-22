package dsa.graphs.test;

import dsa.graphs.main.CycleUndirectedGraphDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CycleUndirectedGraphDFSTest {
    public static void main(String[] args) {
        int passed = 0;

        // List of test cases
        List<Boolean> expectedResults = Arrays.asList(
                false, // TC 1 - Empty graph
                false, // TC 2 - Single node, no edge
                false, // TC 3 - 2 nodes, 1 edge
                true,  // TC 4 - 3 nodes, cycle
                true,  // TC 5 - Square with diagonals
                false, // TC 6 - Tree (acyclic connected graph)
                true,  // TC 7 - Disconnected components, one with cycle
                false, // TC 8 - Disconnected components, none with cycle
                true,  // TC 9 - Self loop
                true   // TC 10 - Parallel edges
        );

        List<List<List<Integer>>> adjListCases = new ArrayList<>();

        // Test Case 1 - Empty graph
        adjListCases.add(buildAdjList(0, new int[][]{}));

        // Test Case 2 - One node, no edges
        adjListCases.add(buildAdjList(1, new int[][]{}));

        // Test Case 3 - Two nodes, one edge
        adjListCases.add(buildAdjList(2, new int[][]{{0, 1}}));

        // Test Case 4 - Three nodes in a cycle
        adjListCases.add(buildAdjList(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));

        // Test Case 5 - Square with diagonals (0-1-2-3-0 + diagonals)
        adjListCases.add(buildAdjList(4, new int[][]{
                {0,1},{1,2},{2,3},{3,0},{0,2},{1,3}
        }));

        // Test Case 6 - Tree (acyclic connected)
        adjListCases.add(buildAdjList(5, new int[][]{{0,1},{0,2},{1,3},{1,4}}));

        // Test Case 7 - Disconnected: 0-1-2 is a cycle, 3-4 is acyclic
        adjListCases.add(buildAdjList(5, new int[][]{{0,1},{1,2},{2,0},{3,4}}));

        // Test Case 8 - Disconnected acyclic components
        adjListCases.add(buildAdjList(6, new int[][]{{0,1},{2,3},{4,5}}));

        // Test Case 9 - Self-loop
        adjListCases.add(buildAdjList(1, new int[][]{{0,0}}));

        // Test Case 10 - Parallel edges (0-1 twice)
        adjListCases.add(buildAdjList(2, new int[][]{{0,1},{0,1}}));

        for (int i = 0; i < adjListCases.size(); i++) {
            boolean result = CycleUndirectedGraphDFS.isCycleUndirectedGraphBFS(adjListCases.get(i).size(), adjListCases.get(i));
            boolean expected = expectedResults.get(i);
            if (result == expected) {
                System.out.println("✅ Test Case " + (i + 1) + " Passed");
                passed++;
            } else {
                System.out.println("❌ Test Case " + (i + 1) + " Failed — Expected: " + expected + ", Got: " + result);
            }
        }

        System.out.println("\nTotal Passed: " + passed + "/" + adjListCases.size());
    }

    private static List<List<Integer>> buildAdjList(int v, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }
}
