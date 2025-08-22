package dsa.graphs.test;

import dsa.graphs.main.BipartiteGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BipartiteGraphTest {
    public static void main(String[] args) {
        BipartiteGraph graphChecker = new BipartiteGraph();
        int passed = 0;

        // 1. Empty graph
        passed += runTestCase(new int[][]{}, true, graphChecker);

        // 2. Single node (no edges)
        passed += runTestCase(new int[][]{{}}, true, graphChecker);

        // 3. Simple bipartite graph
        passed += runTestCase(new int[][]{{1}, {0}}, true, graphChecker);

        // 4. Triangle (odd cycle)
        passed += runTestCase(new int[][]{{1, 2}, {0, 2}, {0, 1}}, false, graphChecker);

        // 5. Square (even cycle)
        passed += runTestCase(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}, true, graphChecker);

        // 6. Disconnected graph, all bipartite
        passed += runTestCase(new int[][]{{1}, {0}, {3}, {2}}, true, graphChecker);

        // 7. Disconnected with one non-bipartite
        passed += runTestCase(new int[][]{{1}, {0}, {3, 4}, {2, 4}, {2, 3}}, false, graphChecker);

        // 8. Star graph
        passed += runTestCase(new int[][]{{1, 2, 3}, {0}, {0}, {0}}, true, graphChecker);

        // 9. K(2,3) bipartite
        passed += runTestCase(new int[][]{
                {2, 3, 4}, {2, 3, 4}, // left side
                {0, 1}, {0, 1}, {0, 1}  // right side
        }, true, graphChecker);

        // 10. Self loop (not bipartite)
        passed += runTestCase(new int[][]{{0}}, false, graphChecker);

        System.out.println("\n✅ Passed " + passed + "/10 test cases.");
    }

    private static int runTestCase(int[][] input, boolean expected, BipartiteGraph graphChecker) {
        List<List<Integer>> adjList = toAdjList(input);
        boolean bfsListResult = BipartiteGraph.isBipartiteGraphBFS(adjList);
        boolean dfsListResult = BipartiteGraph.isBipartiteDFS(adjList);
        boolean bfsMatrixResult = graphChecker.isBipartiteBFS(input);

        boolean passed = bfsListResult == expected &&
                dfsListResult == expected &&
                bfsMatrixResult == expected;

        System.out.println((passed ? "✅" : "❌") + " Input = " + Arrays.deepToString(input)
                + " | Expected = " + expected
                + " | BFS-List = " + bfsListResult
                + " | DFS = " + dfsListResult
                + " | BFS-Matrix = " + bfsMatrixResult);
        return passed ? 1 : 0;
    }

    private static List<List<Integer>> toAdjList(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int[] edges : graph) {
            List<Integer> neighbors = new ArrayList<>();
            for (int v : edges) {
                neighbors.add(v);
            }
            adj.add(neighbors);
        }
        return adj;
    }
}
