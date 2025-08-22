package dsa.graphs.test;

import dsa.graphs.main.SurroundedRegionsReplaceZeroWithX;

import java.util.Arrays;

public class SurroundedRegionsReplaceZeroWithXTest {
    public static void main(String[] args) {
        SurroundedRegionsReplaceZeroWithX solver = new SurroundedRegionsReplaceZeroWithX();

        char[][][] inputs = {
                // TC1: Single cell - O
                {{'O'}},

                // TC2: Single cell - X
                {{'X'}},

                // TC3: Surrounded O
                {
                        {'X', 'X', 'X', 'X'},
                        {'X', 'O', 'O', 'X'},
                        {'X', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'X'}
                },

                // TC4: O on border only
                {
                        {'O', 'O', 'O'},
                        {'O', 'X', 'O'},
                        {'O', 'O', 'O'}
                },

                // TC5: No O's
                {
                        {'X', 'X'},
                        {'X', 'X'}
                },

                // TC6: All O's
                {
                        {'O', 'O'},
                        {'O', 'O'}
                },

                // TC7: All surrounded O's
                {
                        {'X', 'X', 'X'},
                        {'X', 'O', 'X'},
                        {'X', 'X', 'X'}
                },

                // TC8: Complex borders
                {
                        {'X', 'O', 'X', 'X'},
                        {'O', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'O'},
                        {'O', 'X', 'O', 'X'}
                },

                // TC9: Diagonal Os not connected
                {
                        {'O', 'X', 'X'},
                        {'X', 'O', 'X'},
                        {'X', 'X', 'O'}
                },

                // TC10: Large square hole
                {
                        {'X', 'X', 'X', 'X', 'X'},
                        {'X', 'O', 'O', 'O', 'X'},
                        {'X', 'O', 'X', 'O', 'X'},
                        {'X', 'O', 'O', 'O', 'X'},
                        {'X', 'X', 'X', 'X', 'X'}
                }
        };

        char[][][] expectedOutputs = {
                {{'O'}},
                {{'X'}},
                {
                        {'X', 'X', 'X', 'X'},
                        {'X', 'X', 'X', 'X'},
                        {'X', 'X', 'X', 'X'},
                        {'X', 'O', 'X', 'X'}
                },
                {
                        {'O', 'O', 'O'},
                        {'O', 'X', 'O'},
                        {'O', 'O', 'O'}
                },
                {
                        {'X', 'X'},
                        {'X', 'X'}
                },
                {
                        {'O', 'O'},
                        {'O', 'O'}
                },
                {
                        {'X', 'X', 'X'},
                        {'X', 'X', 'X'},
                        {'X', 'X', 'X'}
                },
                {
                        {'X', 'O', 'X', 'X'},
                        {'O', 'X', 'X', 'X'},
                        {'X', 'X', 'X', 'O'},
                        {'O', 'X', 'O', 'X'}
                },
                {
                        {'O', 'X', 'X'},
                        {'X', 'X', 'X'},
                        {'X', 'X', 'O'}
                },
                {
                        {'X', 'X', 'X', 'X', 'X'},
                        {'X', 'X', 'X', 'X', 'X'},
                        {'X', 'X', 'X', 'X', 'X'},
                        {'X', 'X', 'X', 'X', 'X'},
                        {'X', 'X', 'X', 'X', 'X'}
                }
        };

        int passed = 0;

        for (int i = 0; i < inputs.length; i++) {
            char[][] inputCopy = deepCopy(inputs[i]);
            solver.solve(inputCopy);

            if (Arrays.deepEquals(inputCopy, expectedOutputs[i])) {
                System.out.println("✅ Test Case " + (i + 1));
                passed++;
            } else {
                System.out.println("❌ Test Case " + (i + 1));
                System.out.println("Expected:");
                printMatrix(expectedOutputs[i]);
                System.out.println("Got:");
                printMatrix(inputCopy);
            }
        }

        System.out.println("\nPassed: " + passed + "/" + inputs.length);
    }

    private static char[][] deepCopy(char[][] matrix) {
        char[][] copy = new char[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        return copy;
    }

    private static void printMatrix(char[][] mat) {
        for (char[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }
}
