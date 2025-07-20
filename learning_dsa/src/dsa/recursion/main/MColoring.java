package dsa.recursion.main;

import java.util.Arrays;

public class MColoring {

    public static boolean canBeColored(int[][] graph, int maxColors) {
        int[] colorTrack = new int[graph.length];
        Arrays.fill(colorTrack, -1);
        return canBeColored(graph, maxColors, colorTrack, 0, graph.length - 1);
    }

    private static boolean canBeColored(int[][] graph, int maxColors, int[] colorTrack, int curNode, int maxNode) {
        if (curNode > maxNode) {
            return true;
        }

        for (int color = 0; color < maxColors; color++) {
            if (canColorNode(curNode, color, graph, maxNode, colorTrack)) {
                colorTrack[curNode] = color;
                if (canBeColored(graph, maxColors, colorTrack, curNode + 1, maxNode)) return true;
                colorTrack[curNode] = -1;
            }
        }
        return false;
    }

    private static boolean canColorNode(int curNode, int color, int[][] graph, int maxNode, int[] colorTrack) {
        int[] adjacent = graph[curNode];

        for (int isHasLink = 0; isHasLink <= maxNode; isHasLink++) {
            if (adjacent[isHasLink] == 1) {
                if (colorTrack[isHasLink] == color) {
                    return false;
                }
            }
        }
        return true;
    }
}
