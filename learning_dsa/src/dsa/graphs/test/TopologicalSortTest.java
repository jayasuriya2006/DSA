package dsa.graphs.test;

import dsa.graphs.main.TopologicalSort;

import java.util.*;

public class TopologicalSortTest {
    public static void main(String[] args) {
        test(new int[][]{{0, 1}, {1, 2}, {2, 3}}, 4, Arrays.asList(0, 1, 2, 3), 1);
        test(new int[][]{{5, 0}, {4, 0}, {5, 2}, {4, 1}, {2, 3}, {3, 1}}, 6, null, 2); // any valid
        test(new int[][]{}, 0, Collections.emptyList(), 3);  // empty graph
        test(new int[][]{{0, 1}}, 2, Arrays.asList(0, 1), 4);
        test(new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}, 4, null, 5); // any valid
        test(new int[][]{{1, 0}, {0, 1}}, 2, Collections.emptyList(), 6); // cycle
        test(new int[][]{{0, 2}, {1, 2}, {2, 3}}, 4, null, 7); // any valid
        test(new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, 5, Arrays.asList(0, 1, 2, 3, 4), 8);
        test(new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}}, 4, null, 9); // any valid
        test(new int[][]{{0, 1}, {2, 3}}, 4, null, 10); // any valid
    }

    private static void test(int[][] edges, int v, List<Integer> expected, int testCaseNumber) {
        List<Integer> result = TopologicalSort.getTopologicalSort(edges, v);

        // Case 1: expected list provided – check exact match
        if (expected != null) {
            if (result.equals(expected)) {
                System.out.println("✅ Test case " + testCaseNumber + " passed");
            } else {
                System.out.println("❌ Test case " + testCaseNumber + " failed. Expected " + expected + ", Got: " + result);
            }
        }
        // Case 2: expected is null → means we accept any valid topological sort
        else {
            if (isValidTopoSort(result, edges, v)) {
                System.out.println("✅ Test case " + testCaseNumber + " passed");
            } else {
                System.out.println("❌ Test case " + testCaseNumber + " failed. Invalid topological sort: " + result);
            }
        }
    }

    private static boolean isValidTopoSort(List<Integer> result, int[][] edges, int v) {
        if (result.size() != v) return false; // Incomplete sort → cycle detected

        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i < result.size(); i++) {
            position.put(result.get(i), i);
        }

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            if (position.get(from) > position.get(to)) {
                return false;
            }
        }
        return true;
    }
}
