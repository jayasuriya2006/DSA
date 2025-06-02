package dsa.array.test;

import dsa.array.main.NextPermutation;

import java.util.Arrays;

public class NextPermutationTest {

    public static void main(String[] args) {
        //brut force
        //generate all the permutation using recursion
        //sort the generated permutations
        //do linear search

        //optimal
        int[] arr = {2, 1, 5, 4, 3, 0, 0};
        int[] expected = {2, 3, 0, 0, 1, 4, 5};

        NextPermutation.getNextPermutation(arr);

        if (Arrays.equals(arr, expected)) {
            System.out.println("........TEST PASSED.......");
        } else {
            System.out.println("........TEST FAILED.......");
        }

    }
}
