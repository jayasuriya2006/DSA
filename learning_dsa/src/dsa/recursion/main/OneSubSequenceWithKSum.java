package dsa.recursion.main;

import java.util.ArrayList;
import java.util.List;

public class OneSubSequenceWithKSum {

    public static List<Integer> getOneSubSequencesWithSumK(int[] array, int sum) {
        List<Integer> answer = new ArrayList<>();
        getOneSubSequencesWithSumK(array, 0, new ArrayList<>(), answer, sum, 0);
        return answer;
    }

    private static boolean getOneSubSequencesWithSumK(int[] array, int index, List<Integer> curSubSeq, List<Integer> answer, int target, int curSum) {

        //base case
        if (index == array.length) {
            if (curSum == target) {
                answer.addAll(curSubSeq);
                return true;
            }
            return false;
        }

        //include
        curSubSeq.add(array[index]);
        curSum = curSum + array[index];
        if (getOneSubSequencesWithSumK(array, index + 1, curSubSeq, answer, target, curSum)) {
            return true;
        }


        //not include case
        curSubSeq.removeLast();
        curSum = curSum - array[index];
        if (getOneSubSequencesWithSumK(array, index + 1, curSubSeq, answer, target, curSum)) {
            return true;
        }

        // If no subsequence found that sums to target, return false
        return false;
    }
}
