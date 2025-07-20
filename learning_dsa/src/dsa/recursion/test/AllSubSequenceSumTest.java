package dsa.recursion.test;

import java.util.Arrays;
import java.util.List;

public class AllSubSequenceSumTest {
    public static void main(String[] args) {
        int[] input = {1, 2, 3};

        List<Integer> expectedSums = Arrays.asList(0, 1, 2, 3, 3, 4, 5, 6);
        List<Integer> actualSums = dsa.recursion.main.AllSubSequenceSum.getAllSubSeqSum(input);

        if (expectedSums.equals(actualSums)) {
            System.out.println("✅ TEST PASSED");
        } else {
            System.out.println("❌ TEST FAILED");
            System.out.println("Expected sums: " + expectedSums);
            System.out.println("Actual sums:   " + actualSums);
        }
    }


}
