package dsa.array.test;

import dsa.array.main.FourSum;

import java.util.ArrayList;
import java.util.List;

import static dsa.array.test.ThreeSumTest.testResult;

public class FourSumTest {
    /*
    The 4 Sum problem involves finding all unique quadruplets in an array that sum up to a given target.

    nums = [1, 0, -1, 0, -2, 2]
    target = 0
    Expected Output: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]

    nums = [2, 2, 2, 2, 2]
    target = 8
    Expected Output: [[2, 2, 2, 2]]

    nums = [0, 0, 0, 0]
    target = 0
    Expected Output: [[0, 0, 0, 0]]

    nums = [1, 2, 3, 4]
    target = 100
    Expected Output: []

    nums = [-3, -1, 0, 2, 4, 5]
    target = 2
    Expected Output: [[-3, -1, 2, 4], [-3, 0, 2, 3], [-1, 0, 2, 1]] — depends on data
    */

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(-2, -1, 1, 2));
        expected.add(List.of(-2, 0, 0, 2));
        expected.add(List.of(-1, 0, 0, 1));

        // Run BRUTE
        List<List<Integer>> res_brut = FourSum.getFourSum_Brut(arr, target);
        testResult(res_brut, expected, "BRUT");

        // Run BETTER
        List<List<Integer>> res_better = FourSum.getFourSum_Better(arr, target);
        testResult(res_better, expected, "BETTER");

        // Run OPTIMAL
        List<List<Integer>> res_optimal = FourSum.getFourSum_Optimal(arr, target);
        testResult(res_optimal, expected, "OPTIMAL");
    }


}
