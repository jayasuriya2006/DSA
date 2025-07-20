package dsa.array.test;

import dsa.array.main.MergeSortedArraysWithoutExtraSpace;

public class MergeSortedArraysWithoutExtraSpaceTest {
    public static void main(String[] args) {
        int[] arr3 = {-5, -2, 4, 5};
        int[] arr4 = {1, 3, 8};

        int[] arr1 = {0, 2, 7, 8};
        int[] arr2 = {-7, -3, -1};

        MergeSortedArraysWithoutExtraSpace.mergeArray_Brut(arr1, arr2);
        printTestRes(arr1, arr2, "BRUT");

        MergeSortedArraysWithoutExtraSpace.mergeArray_Optimal(arr3, arr4);
        printTestRes(arr3, arr4, "OPTIMAL");

    }

    private static void printTestRes(int[] arr1, int[] arr2, String testAproach) {
        boolean passes = true;
        int n = arr1.length;
        int m = arr2.length;
        if (arr2[0] < arr1[n - 1]) {
            passes = false;
        } else {
            for (int i = 1; i < n; i++) {
                if (arr1[i] < arr1[i - 1]) {
                    passes = false;
                }
            }
            for (int i = 1; i < m; i++) {
                if (arr2[i] < arr2[i - 1]) {
                    passes = false;
                }
            }
        }

        if (passes) {
            System.out.println(".......... " + testAproach + " TEST PASSED..........");
        } else {
            System.out.println("......... " + testAproach + " TEST FAILED.........");
        }
    }
}
