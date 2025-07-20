package dsa.array.test;

import dsa.array.main.TwoSumProblem;

import java.util.Arrays;

public class TwoSumProblemTest {
    public static void main(String[] args) {
        int[] arr = {1, 10, 2, 2, 5, 4, 2, 9, 5, 3, 10};
        int target = 20;
        int[] expectedOutput = {1, 10};
        String expected_s = "YES";    // "NO"

        int[] output_brut = TwoSumProblem.getTwoIndexesSumAsTar_Brut(arr, target);
        int[] output_better = TwoSumProblem.getTwoIndexesSumAsTar_Better(arr, target);
        String output_optimal = TwoSumProblem.getTwoIndexesSumAsTar_Optimal(arr, target);

        if (Arrays.equals(output_brut, expectedOutput)) {
            System.out.println("......BRUT - TEST PASSED.........");
        } else {
            System.out.println(".......BRUT - TEST FAILED..........");
        }

        if (Arrays.equals(output_better, expectedOutput)) {
            System.out.println("......BETTER - TEST PASSED.........");
        } else {
            System.out.println(".......BETTER - TEST FAILED..........");
        }

        if (output_optimal.equals(expected_s)) {
            System.out.println("......OPTIMAL - TEST PASSED.........");
        } else {
            System.out.println(".......OPTIMAL - TEST FAILED..........");
        }

    }
}
