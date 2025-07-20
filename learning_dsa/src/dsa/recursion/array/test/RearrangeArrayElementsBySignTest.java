package dsa.array.test;

import dsa.array.main.RearrangeArrayElementsBySign;

import java.util.Arrays;

/*
Given an integer array nums of even length consisting of an equal number of positive and negative integers.Return the answer array in such a way that the given conditions are met:


Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.

Examples:
Input : nums = [2, 4, 5, -1, -3, -4]

Output : [2, -1, 4, -3, 5, -4]

Explanation: The positive number 2, 4, 5 maintain their relative positions and -1, -3, -4 maintain their relative positions

Input : nums = [1, -1, -3, -4, 2, 3]

Output : [1, -1, 2, -3, 3, -4]

Explanation: The positive number 1, 2, 3 maintain their relative positions and -1, -3, -4 maintain their relative positions
 */
public class RearrangeArrayElementsBySignTest {

    public static void main(String[] args) {
        int[] arr1_Brut = {1, -1, -3, -4, 2, 3};
        int[] arr1_Better = {1, -1, -3, -4, 2, 3};
        int[] expected1 = {1, -1, 2, -3, 3, -4};

        int[] arr2 = {1, -1, -3, -4, 2, 3, -1, -4, 5, -9, -3, 2, -8};
        int[] expected2 = {1, -1, 2, -3, 3, -4, 5, -1, 2, -4, -9, -3, -8};

        //no of pos and neg are equal
        int[] res1_Brut = RearrangeArrayElementsBySign.reArrangeBySign_Brut(arr1_Brut);
        int[] res1_Better = RearrangeArrayElementsBySign.reArrangeBySign_Better(arr1_Better);

        //no of pos and neg are not equal
        int[] res2_Brut = RearrangeArrayElementsBySign.reArrangeBySign_2_Brut(arr2);

        System.out.println("No of Positives and Negatives are equal:");
        if (Arrays.equals(res1_Brut, expected1)) {
            System.out.println(".....BRUT - TEST PASSED.......");
        } else {
            System.out.println(".....BRUT - TEST Failed.......");
        }

        if (Arrays.equals(res1_Better, expected1)) {
            System.out.println(".....BETTER - TEST PASSED.......");
        } else {
            System.out.println(".....BETTER - TEST Failed.......");
        }

        System.out.println("No of Positives and Negatives are NOT equal:");
        if (Arrays.equals(res2_Brut, expected2)) {
            System.out.println(".....BRUT - TEST PASSED.......");
        } else {
            System.out.println(".....BRUT - TEST Failed.......");
        }


    }
}
