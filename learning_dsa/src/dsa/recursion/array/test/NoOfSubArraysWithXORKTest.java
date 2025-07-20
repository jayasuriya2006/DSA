package dsa.array.test;

import dsa.array.main.NoOfSubArraysWithXORK;

public class NoOfSubArraysWithXORKTest {

    /*
     Input : nums = [4, 2, 2, 6, 4], k = 6
     Output : 4
     Explanation : The subarrays having XOR of their elements as 6 are [4, 2],  [4, 2, 2, 6, 4], [2, 2, 6], and [6]

    Input :nums = [5, 6, 7, 8, 9], k = 5
    Output : 2
    Explanation : The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]

     */

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9};
        int k = 5;

        int expectedAns = 2;

        int res_brut = NoOfSubArraysWithXORK.getNoOfSubArraysWithXOR_K_Brut(arr, k);
        int res_better = NoOfSubArraysWithXORK.getNoOfSubArraysWithXOR_K_Better(arr, k);
        int res_optimal = NoOfSubArraysWithXORK.getNoOfSubArraysWithXOR_K_Optimal(arr, k);

        if (expectedAns == res_brut) {
            System.out.println("........ BRUT - TEST PASSED.........");
        } else {
            System.out.println("........ BRUT - TEST FAILED.........");
        }

        if (expectedAns == res_better) {
            System.out.println("........ BETTER - TEST PASSED.........");
        } else {
            System.out.println("........ BETTER - TEST FAILED.........");
        }

        if (expectedAns == res_optimal) {
            System.out.println("........ OPTIMAL - TEST PASSED.........");
        } else {
            System.out.println("........ OPTIMAL - TEST FAILED.........");
        }

    }
}
