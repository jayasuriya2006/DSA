package dsa.recursion.main;

import java.util.ArrayList;
import java.util.List;

public class AllSubSequencesWithKSum {

    public static List<List<Integer>> getAllSubSequencesWithSumK(int[] array, int sum) {
        List<List<Integer>> allSubsequences = new ArrayList<>();
        getAllSubSequencesWithSumK(array, 0, new ArrayList<>(), allSubsequences, sum, 0);
        return allSubsequences;
    }

    private static void getAllSubSequencesWithSumK(int[] array, int index, List<Integer> curSubSeq, List<List<Integer>> allSubSequences, int target, int curSum) {

        //base case
        if (index == array.length) {
            if (curSum == target) {
                allSubSequences.add(new ArrayList<>(curSubSeq));
            }
            return;
        }

        //include
        curSubSeq.add(array[index]);
        curSum = curSum + array[index];
        getAllSubSequencesWithSumK(array, index + 1, curSubSeq, allSubSequences, target, curSum);

        //not include case
        curSubSeq.removeLast();
        curSum = curSum - array[index];
        getAllSubSequencesWithSumK(array, index + 1, curSubSeq, allSubSequences, target, curSum);
    }
}
