package dsa.recursion.test;

import dsa.recursion.main.MColoring;
import dsa.recursion.main.MColoringAllPossibleWay;

import java.util.List;

public class MColoringAllPossibleWayTest {
    public static void main(String[] args) {

        int graph[][] = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        };

        List<List<Integer>> allPossibleWay = MColoringAllPossibleWay.getAllPossibleWay(graph, 3);
        for (List<Integer> way : allPossibleWay) {
            System.out.println(way);
        }

    }
}
