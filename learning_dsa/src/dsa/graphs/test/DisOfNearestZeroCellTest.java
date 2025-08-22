package dsa.graphs.test;

import dsa.graphs.main.DisOfNearestZeroCell;

import java.util.Arrays;

public class DisOfNearestZeroCellTest {
    public static void main(String[] args) {
        DisOfNearestZeroCell solver = new DisOfNearestZeroCell();

        int[][][] testInputs = {
                // TC 1: Simple 1x1 matrix with 0
                {{0}},

                // TC 2: 1x1 matrix with 1
                {{1}},

                // TC 3: All zeros
                {
                        {0, 0},
                        {0, 0}
                },

                // TC 4: All ones
                {
                        {1, 1},
                        {1, 1}
                },

                // TC 5: Mix 0s and 1s
                {
                        {0, 0, 0},
                        {0, 1, 0},
                        {1, 1, 1}
                },

                // TC 6: One row
                {
                        {1, 0, 1, 1, 0}
                },

                // TC 7: One column
                {
                        {1},
                        {0},
                        {1},
                        {1}
                },

                // TC 8: Diagonal zeros
                {
                        {0, 1, 1},
                        {1, 0, 1},
                        {1, 1, 0}
                },

                // TC 9: Large center 1
                {
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                },

                // TC 10: Surrounded center 0
                {
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 1, 1}
                }
        };

        int[][][] expectedOutputs = {
                {{0}},
                {{Integer.MAX_VALUE}}, // We'll handle this as special case
                {
                        {0, 0},
                        {0, 0}
                },
                {
                        {Integer.MAX_VALUE, Integer.MAX_VALUE},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE}
                },
                {
                        {0, 0, 0},
                        {0, 1, 0},
                        {1, 2, 1}
                },
                {
                        {1, 0, 1, 1, 0}
                },
                {
                        {1},
                        {0},
                        {1},
                        {2}
                },
                {
                        {0, 1, 2},
                        {1, 0, 1},
                        {2, 1, 0}
                },
                {
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                },
                {
                        {2, 1, 2},
                        {1, 0, 1},
                        {2, 1, 2}
                }
        };

        for (int i = 0; i < testInputs.length; i++) {
            int[][] input = testInputs[i];
            int[][] expected = expectedOutputs[i];
            int[][] result = solver.updateMatrix(copyMatrix(input));

            boolean passed = true;
            for (int r = 0; r < expected.length; r++) {
                for (int c = 0; c < expected[0].length; c++) {
                    int expectedVal = expected[r][c];
                    if (expectedVal == Integer.MAX_VALUE) continue; // Skip for undefined output
                    if (result[r][c] != expectedVal) {
                        passed = false;
                        break;
                    }
                }
            }

            System.out.println((passed ? "✅" : "❌") + " Test Case " + (i + 1));
            if (!passed) {
                System.out.println("Input:");
                printMatrix(input);
                System.out.println("Expected:");
                printMatrix(expected);
                System.out.println("Got:");
                printMatrix(result);
                System.out.println();
            }
        }
    }

    private static int[][] copyMatrix(int[][] matrix) {
        int[][] copy = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        return copy;
    }

    private static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }
}
