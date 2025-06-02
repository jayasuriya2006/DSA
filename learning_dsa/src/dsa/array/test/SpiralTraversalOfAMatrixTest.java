package dsa.array.test;

import dsa.array.main.SpiralTraversalOfAMatrix;

import java.util.List;

public class SpiralTraversalOfAMatrixTest {

    /*
         Given an M * N matrix, print the elements in a clockwise spiral manner.
         Return an array with the elements in the order of their appearance when printed in a spiral manner.

         Input: matrix = [[1, 2, 3], [4 ,5 ,6], [7, 8, 9]]
         Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
         Explanation: The elements in the spiral order are 1, 2, 3 -> 6, 9 -> 8, 7 -> 4, 5

         Input: matrix = [[1, 2, 3, 4], [5, 6, 7, 8]]
         Output: [1, 2, 3, 4, 8, 7, 6, 5]
         Explanation: The elements in the spiral order are 1, 2, 3, 4 -> 8, 7, 6, 5

         */
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };

        List<Integer> expected = List.of(1, 2, 3, 4, 8, 7, 6, 5);

        List<Integer> output = SpiralTraversalOfAMatrix.getSpiralTraversal(matrix);

        if (expected.equals(output)) {
            System.out.println("........TEST PASSED.........");
        } else {
            System.out.println("........TEST FAILED.........");
        }

    }
}
