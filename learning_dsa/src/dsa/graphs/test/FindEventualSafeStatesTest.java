package dsa.graphs.test;

import dsa.graphs.main.FindEventualSafeStates;

import java.util.Arrays;
import java.util.List;

public class FindEventualSafeStatesTest {
    public static void main(String[] args) {
        FindEventualSafeStates solver = new FindEventualSafeStates();

        test(solver, new int[][]{
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        }, Arrays.asList(2, 4, 5, 6), 1);  // Safe: 2,4,5,6

        test(solver, new int[][]{
                {1},
                {2},
                {0}
        }, Arrays.asList(), 2); // Cycle, no safe nodes

        test(solver, new int[][]{
                {},
                {},
                {}
        }, Arrays.asList(0, 1, 2), 3); // All terminal nodes

        test(solver, new int[][]{
                {1},
                {2},
                {},
                {4},
                {}
        }, Arrays.asList(0, 1, 2, 3, 4), 4); // No cycles, all safe

        test(solver, new int[][]{
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {6},
                {4}
        }, Arrays.asList(), 5); // Cycle between 0->1->2->3->0, but 2,5,6 are safe

        test(solver, new int[][]{}, Arrays.asList(), 6); // Empty graph

        test(solver, new int[][]{{}}, Arrays.asList(0), 7); // One node, no edges

        test(solver, new int[][]{{1}, {2}, {3}, {4}, {}}, Arrays.asList(0, 1, 2, 3, 4), 8); // Linear graph

        test(solver, new int[][]{{0}}, Arrays.asList(), 9); // Self-loop

        test(solver, new int[][]{{1}, {2}, {3}, {1}}, Arrays.asList(), 10); // Cycle: 1->2->3->1
    }

    private static void test(FindEventualSafeStates solver, int[][] graph, List<Integer> expected, int testCaseNumber) {
        List<Integer> result = solver.eventualSafeNodes(graph);
        if (result.equals(expected)) {
            System.out.println("✅ Test case " + testCaseNumber + " passed");
        } else {
            System.out.println("❌ Test case " + testCaseNumber + " failed");
            System.out.println("   Expected: " + expected);
            System.out.println("   Got     : " + result);
        }
    }
}
