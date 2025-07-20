package dsa.recursion.test;

import dsa.recursion.main.MColoring;

public class MColoringTest {

    public static void main(String[] args) {
        int graph[][] = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        };

        boolean canColored = MColoring.canBeColored(graph, 1);
        System.out.println(canColored);
    }
}
