package dsa.stackqueue.test;

import static dsa.stackqueue.main.MaxRectangleAreaInMatrix.maxRectangleAreaInMatrix;

public class MaxRectangleAreaInMatrixTest {
    public static void main(String[] args) {

        int[][][] testInputs = {
                {
                        {1, 0, 1, 0, 0},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 1, 1},
                        {1, 0, 0, 1, 0}
                },
                {
                        {0}
                },
                {
                        {1}
                },
                {
                        {0, 0},
                        {0, 0}
                },
                {
                        {1, 1},
                        {1, 1}
                },
                {},
                {
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1}
                }
        };

        int[] expectedOutputs = {
                6,
                0,
                1,
                0,
                4,
                0,
                9
        };

        for (int i = 0; i < testInputs.length; i++) {
            int result = maxRectangleAreaInMatrix(testInputs[i]);
            System.out.println("Test case " + (i + 1));
            System.out.println("Expected: " + expectedOutputs[i]);
            System.out.println("Actual:   " + result);
            System.out.println(result == expectedOutputs[i] ? "✅ Passed" : "❌ Failed");
            System.out.println("-----------");
        }
    }
}


