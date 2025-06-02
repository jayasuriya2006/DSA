package dsa.array.test;

import dsa.array.main.SortArrayZeroOneTwo;

import java.util.Arrays;

public class SortArrayZeroOneTwoTest {

    public static void main(String[] args) {
        int[] arr_optimal = {0, 0, 2, 0, 1, 0, 2, 2, 0, 1, 2, 2, 1, 0};
        int[] arr_brut = {0, 0, 2, 0, 1, 0, 2, 2, 0, 1, 2, 2, 1, 0};
        int[] arr_better = {0, 0, 2, 0, 1, 0, 2, 2, 0, 1, 2, 2, 1, 0};
        int[] expected = {0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2};

        SortArrayZeroOneTwo.sortArray_0_1_2_Brut(arr_brut);
        SortArrayZeroOneTwo.sortArray_0_1_2_Better(arr_better);
        SortArrayZeroOneTwo.sortArray_0_1_2_Optimal(arr_optimal);

        if (Arrays.equals(expected, arr_brut)) {
            System.out.println("........BRUT - TEST PASSED........");
        } else {
            System.out.println("........BRUT - TEST FAILED........");
        }

        if (Arrays.equals(expected, arr_better)) {
            System.out.println("........BETTER - TEST PASSED........");
        } else {
            System.out.println("........BETTER - TEST FAILED........");
        }

        if (Arrays.equals(expected, arr_optimal)) {
            System.out.println("........OPTIMAL - TEST PASSED........");
        } else {
            System.out.println("........OPTIMAL - TEST FAILED........");
        }
    }
}
