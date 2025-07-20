package dsa.recursion.test;

import java.util.ArrayList;
import java.util.List;

public class OneSubSequenceWithKSumTest {

    public static void main(String[] args) {
        int[] intput = {1, 2, 3, 4, 5};
        int target = 5;

        List<Integer> actualAns = dsa.recursion.main.OneSubSequenceWithKSum.getOneSubSequencesWithSumK(intput, target);

        int sum = 0;
        for (int n : actualAns) {
            sum += n;
        }
        if (sum == target) {
            System.out.println("..........TEST PASSED.............");
        } else {
            System.out.println("..........TEST FAILED.............");
        }
    }
}
