package dsa.graphs.main;

import java.util.List;

import static dsa.graphs.main.TopologicalSort.getTopologicalSort;

public class DtctCycleInDirectedGraphTopo {

    public static boolean isDirectedGraphHasCycleDFS(int[][] adj, int v) {
        List<Integer> topo = getTopologicalSort(adj, v);
        return !(topo.size() == v);
    }
}
