package dsa.array.test;

import dsa.array.main.ThreeSum;

import java.util.ArrayList;
import java.util.List;

public class ThreeSumTest {
    /*
     The 3 Sum problem involves finding all unique triplets in an array that sum up to a given target

     nums = [1, 2, -2, -1]
     target = 0
     Expected Output: [[1, -2, 1]]


     nums = [-1, 0, 1, 2, -1, -4]
     target = 0
     Expected Output: [[-1, -1, 2], [-1, 0, 1]]


     nums = [1, 2, 3, 4, 5]
     target = 50
     Expected Output: []


     nums = [0, 0, 0, 0]
     target = 0
     Expected Output: [[0, 0, 0]]

     nums = [-5, -2, -3, 1, 2, 3, 4]
     target = -6
     Expected Output: [[-5, -2, 1], [-5, -3, 2], [-3, -2, -1]]

     nums = [3, 0, -2, -1, 1, 2, -1, -4, 2]
     target = 0
     Expected Output: [[-4, 2, 2], [-2, -1, 3], [-2, 0, 2], [-1, -1, 2], [-1, 0, 1]]

     nums = [1, 2]
     target = 3
     Expected Output: []
     */
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0};
        int target = 0;

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(0, 0, 0));
        //expected.add(List.of(-2, -1, 3));
        //expected.add(List.of(-2, 0, 2));
        //expected.add(List.of(-1, -1, 2));
        //expected.add(List.of(-1, 0, 1));
        //expected.add(List.of(-4, 1, 3));

        List<List<Integer>> res_brut = ThreeSum.getThreeSum_Brut(arr, target);
        testResult(res_brut, expected, "BRUT - ");

        List<List<Integer>> res_better = ThreeSum.getThreeSum_Better(arr, target);
        testResult(res_better, expected, "BETTER - ");

        List<List<Integer>> res_optimal = ThreeSum.getThreeSum_Optimal(arr, target);
        testResult(res_optimal, expected, "OPTIMAL - ");

    }

    public static void testResult(List<List<Integer>> actual, List<List<Integer>> expected, String approachName) {
        boolean passed = true;

        if (actual.size() != expected.size()) {
            passed = false;
        } else {
            for (List<Integer> temp : expected) {
                if (!actual.contains(temp)) {
                    passed = false;
                    break;
                }
            }
        }

        if (passed) {
            System.out.println("........." + approachName + " - TEST PASSED.......");
        } else {
            System.out.println("........." + approachName + " - TEST FAILED.......");
        }
    }
}
