package dsa.recursion.main;

import java.util.ArrayList;
import java.util.List;

public class CountSubSequencesWithKSum {

    public static int countSubSequencesWithSumK(int[] array, int sum) {

        return countSubSequencesWithSumK(array, 0, new ArrayList<>(), sum, 0);
    }

    private static int countSubSequencesWithSumK(int[] array, int index, List<Integer> curSubSeq, int target, int curSum) {

        //base case
        if (index == array.length) {
            if (curSum == target) {
                return 1;
            }
            return 0;
        }

        //include
        curSubSeq.add(array[index]);
        curSum = curSum + array[index];
        int include = countSubSequencesWithSumK(array, index + 1, curSubSeq, target, curSum);

        //not include case
        curSubSeq.removeLast();
        curSum = curSum - array[index];
        int notInclude = countSubSequencesWithSumK(array, index + 1, curSubSeq, target, curSum);


        return include + notInclude;
    }
}
