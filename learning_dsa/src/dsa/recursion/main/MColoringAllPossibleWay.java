package dsa.recursion.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MColoringAllPossibleWay {
    public static List<List<Integer>> getAllPossibleWay(int[][] graph, int maxColors) {
        List<List<Integer>> allPossibleWay = new ArrayList<>();
        int[] colorTrack = new int[graph.length];
        Arrays.fill(colorTrack, -1);
        getAllPossibleWay(graph, maxColors, colorTrack, 0, graph.length - 1, allPossibleWay);
        return allPossibleWay;
    }

    private static void getAllPossibleWay(int[][] graph, int maxColors, int[] colorTrack, int curNode, int maxNode, List<List<Integer>> allPossibleWay) {
        if (curNode > maxNode) {
            List<Integer> curPossibleWay = new ArrayList<>();
            for (int color : colorTrack) {
                curPossibleWay.add(color);
            }
            allPossibleWay.add(curPossibleWay);
            return;
        }

        for (int color = 0; color < maxColors; color++) {
            if (canColorNode(curNode, color, graph, maxNode, colorTrack)) {
                colorTrack[curNode] = color;
                getAllPossibleWay(graph, maxColors, colorTrack, curNode + 1, maxNode, allPossibleWay);
                colorTrack[curNode] = -1;
            }
        }
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
