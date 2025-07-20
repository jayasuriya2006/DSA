package dsa.binarysearch.test;

import static dsa.binarysearch.main.SquareRoot.getSquareRoot;

public class SquareRootTest {
    public static void main(String[] args) {
        int[] testInputs = {
                0,   // √0 = 0
                1,   // √1 = 1
                2,   // √2 ≈ 1.41 -> 1
                3,   // √3 ≈ 1.73 -> 1
                4,   // √4 = 2
                10,  // √10 ≈ 3.16 -> 3
                15,  // √15 ≈ 3.87 -> 3
                16,  // √16 = 4
                17,  // √17 ≈ 4.12 -> 4
                30,  // √30 ≈ 5.47 -> 5
                35,  // √35 ≈ 5.91 -> 5
                36,  // √36 = 6
                100, // √100 = 10
                101, // √101 ≈ 10.05 -> 10
                121, // √121 = 11
                144  // √144 = 12
        };

        int[] expectedResults = {
                0, 1, 1, 1, 2, 3, 3, 4, 4,
                5, 5, 6, 10, 10, 11, 12
        };

        for (int i = 0; i < testInputs.length; i++) {
            int result = getSquareRoot(testInputs[i]);
            boolean passed = result == expectedResults[i];
            System.out.println("Input: " + testInputs[i] +
                    ", Expected: " + expectedResults[i] +
                    ", Got: " + result +
                    (passed ? " ✅" : " ❌"));
        }
    }
}
