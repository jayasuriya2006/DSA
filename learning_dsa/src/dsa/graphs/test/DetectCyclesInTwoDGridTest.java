package dsa.graphs.test;

import dsa.graphs.main.DetectCyclesInTwoDGrid;

public class DetectCyclesInTwoDGridTest {
    public static void main(String[] args) {
        DetectCyclesInTwoDGrid solver = new DetectCyclesInTwoDGrid();

        Object[][] testCases = {
                // Test Case 1: Simple 2x2 cycle
                {
                        new char[][]{
                                {'a', 'a'},
                                {'a', 'a'}
                        }, true
                },

                // Test Case 2: No cycle, straight path
                {
                        new char[][]{
                                {'a', 'b', 'c'},
                                {'d', 'e', 'f'}
                        }, false
                },

                // Test Case 3: Smallest grid (1x1)
                {
                        new char[][]{
                                {'a'}
                        }, false
                },

                // Test Case 4: L-shaped cycle
                {
                        new char[][]{
                                {'a', 'a', 'a'},
                                {'a', 'b', 'a'},
                                {'a', 'a', 'a'}
                        }, true
                },

                // Test Case 5: Diagonal same letters but no cycle
                {
                        new char[][]{
                                {'a', 'b'},
                                {'b', 'a'}
                        }, false
                },

                // Test Case 6: Long vertical strip without cycle
                {
                        new char[][]{
                                {'a'},
                                {'a'},
                                {'a'},
                                {'a'}
                        }, false
                },

                // Test Case 7: Square with different border (no cycle)
                {
                        new char[][]{
                                {'a', 'b', 'a'},
                                {'b', 'a', 'b'},
                                {'a', 'b', 'a'}
                        }, false
                },

                // Test Case 8: Cycle in center
                {
                        new char[][]{
                                {'b', 'b', 'b'},
                                {'b', 'a', 'b'},
                                {'b', 'b', 'b'}
                        }, true
                },

                // Test Case 9: Horizontal loop
                {
                        new char[][]{
                                {'a', 'a', 'a', 'a'}
                        }, false // No cycle because it's a line, not a loop
                },

                // Test Case 10: Big grid with isolated cycle
                {
                        new char[][]{
                                {'c', 'c', 'c', 'd'},
                                {'c', 'a', 'c', 'd'},
                                {'c', 'c', 'c', 'd'},
                                {'d', 'd', 'd', 'd'}
                        }, true
                }
        };

        int testNum = 1;
        for (Object[] testCase : testCases) {
            char[][] grid = (char[][]) testCase[0];
            boolean expected = (boolean) testCase[1];
            boolean result = solver.containsCycle(grid);
            System.out.println("Test Case " + testNum + ": " + (result == expected ? "Passed" : "Failed"));
            testNum++;
        }
    }
}
