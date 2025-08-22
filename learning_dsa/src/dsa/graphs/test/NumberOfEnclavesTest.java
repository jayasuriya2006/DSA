package dsa.graphs.test;

import dsa.graphs.main.NumberOfEnclaves;

import java.util.Arrays;

public class NumberOfEnclavesTest {
    public static void main(String[] args) {
        NumberOfEnclaves solver = new NumberOfEnclaves();

        int[][][] testGrids = {
                // TC1: Empty grid
                {
                        {0, 0},
                        {0, 0}
                },

                // TC2: All land but on border
                {
                        {1, 1},
                        {1, 1}
                },

                // TC3: Land in center, surrounded
                {
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                },

                // TC4: Land on edge only
                {
                        {1, 0, 1},
                        {0, 0, 0},
                        {1, 0, 1}
                },

                // TC5: Mixed, with 2 enclaves
                {
                        {0, 1, 0, 0},
                        {1, 1, 1, 0},
                        {0, 1, 0, 0},
                        {1, 0, 0, 1}
                },

                // TC6: Large enclave block
                {
                        {0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 0},
                        {0, 1, 1, 1, 0},
                        {0, 1, 1, 1, 0},
                        {0, 0, 0, 0, 0}
                },

                // TC7: Border-connected snake
                {
                        {1, 1, 1, 1},
                        {0, 0, 0, 1},
                        {1, 1, 1, 1}
                },

                // TC8: Single enclave
                {
                        {1, 0, 1},
                        {0, 1, 0},
                        {1, 0, 1}
                },

                // TC9: No land at all
                {
                        {0, 0, 0},
                        {0, 0, 0},
                        {0, 0, 0}
                },

                // TC10: Complex border open
                {
                        {0, 1, 0, 1, 0},
                        {1, 1, 1, 1, 1},
                        {0, 1, 0, 1, 0},
                        {1, 1, 1, 1, 1},
                        {0, 1, 0, 1, 0}
                }
        };

        int[] expectedResults = {
                0,  // TC1
                0,  // TC2 (all land reachable from border)
                1,  // TC3
                0,  // TC4
                0,  // TC5 (cells (1,1) and (1,2))
                9,  // TC6
                0,  // TC7 (all reachable from border)
                1,  // TC8 (only center is enclosed)
                0,  // TC9
                0  // TC10
        };

        int passed = 0;
        for (int i = 0; i < testGrids.length; i++) {
            int result = solver.numEnclaves(deepCopy(testGrids[i]));
            if (result == expectedResults[i]) {
                System.out.println("✅ Test Case " + (i + 1));
                passed++;
            } else {
                System.out.println("❌ Test Case " + (i + 1));
                System.out.println("Expected: " + expectedResults[i] + " | Got: " + result);
                System.out.println("Input:");
                printMatrix(testGrids[i]);
            }
        }

        System.out.println("\nPassed: " + passed + " / " + testGrids.length);
    }

    private static int[][] deepCopy(int[][] mat) {
        int[][] copy = new int[mat.length][];
        for (int i = 0; i < mat.length; i++) {
            copy[i] = Arrays.copyOf(mat[i], mat[i].length);
        }
        return copy;
    }

    private static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }
}
