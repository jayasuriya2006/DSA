package dsa.recursion.main;

import java.util.ArrayList;
import java.util.List;

public class AllSubSeqWithKSumInfinite {

    public static List<List<Integer>> getSubSeqWithKSum(int[] array, int target) {
        List<List<Integer>> allSubSeq = new ArrayList<>();
        getSubSeqWithKSum(0, array, target, allSubSeq, new ArrayList<>(), 0);
        return allSubSeq;
    }

    private static void getSubSeqWithKSum(int index, int[] array, int target, List<List<Integer>> allSubSeq, List<Integer> curSubSeq, int curSum) {

        if (index == array.length) {
            if (curSum == target) {
                allSubSeq.add(new ArrayList<>(curSubSeq));
            }
            return;
        }

        //include - infinite time  , check sum exceeds and stay in the same index
        if (curSum + array[index] <= target) {
            curSubSeq.add(array[index]);

            //stay in same index
            getSubSeqWithKSum(index, array, target, allSubSeq, curSubSeq, curSum + array[index]);

            //backtrack - remove last added element from curSubSeq
            curSubSeq.removeLast();
        }

        //not include - move next index with same curSum
        getSubSeqWithKSum(index + 1, array, target, allSubSeq, curSubSeq, curSum);
    }
}
