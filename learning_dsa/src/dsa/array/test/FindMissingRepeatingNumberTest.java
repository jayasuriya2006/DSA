package dsa.array.test;

import dsa.array.main.FindMissingRepeatingNumber;
import dsa.array.main.FindNumberWhichAppearsOneTime;

public class FindMissingRepeatingNumberTest {
    /*
    Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing.
    Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.

    Examples:
    Input: nums = [3, 5, 4, 1, 1]
    Output: [1, 2]
    Explanation: 1 appears two times in the array and 2 is missing from nums

    Input: nums = [1, 2, 3, 6, 7, 5, 7]
    Output: [7, 4]
    Explanation: 7 appears two times in the array and 4 is missing from nums.
     */

    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 6, 7, 5, 7};

        int repeating = 7;
        int missing = 4;

        int[] resultBrut = FindMissingRepeatingNumber.findMissingAndRepeatingNumber_Brut(arr, arr.length);
        int[] resultOptimal = FindMissingRepeatingNumber.findMissingAndRepeatingNumber_Optimal(arr, arr.length);

        if (resultBrut[0] == repeating && resultBrut[1] == missing) {
            System.out.println("..............BURT - TEST PASSED...............");
        } else {
            System.out.println("..............BURT - TEST FAILED...............");
        }

        if (resultOptimal[0] == repeating && resultOptimal[1] == missing) {
            System.out.println("..............OPTIMAL - TEST PASSED...............");
        } else {
            System.out.println("..............OPTIMAL - TEST FAILED...............");
        }
    }
}
