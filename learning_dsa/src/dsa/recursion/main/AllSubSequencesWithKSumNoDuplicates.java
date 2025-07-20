package dsa.recursion.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubSequencesWithKSumNoDuplicates {

    public static List<List<Integer>> getAllSubSeqWithKSumNoDuplicates(int[] array, int target) {
        List<List<Integer>> allSubSeq = new ArrayList<>();
        Arrays.sort(array);
        getAllSubSeqWithKSumNoDuplicates(0, array, allSubSeq, new ArrayList<>(), target, 0);
        return allSubSeq;
    }

    private static void getAllSubSeqWithKSumNoDuplicates(int index, int[] array, List<List<Integer>> allSubSeq, List<Integer> curSubSeq, int target, int curSum) {


        if (curSum == target) {
            allSubSeq.add(new ArrayList<>(curSubSeq));
            return;
        }


        for (int i = index; i < array.length; i++) {
            //avoid duplicate
            if (i != index && array[i] == array[i - 1]) {
                continue;
            }

            curSubSeq.add(array[i]);
            getAllSubSeqWithKSumNoDuplicates(i + 1, array, allSubSeq, curSubSeq, target, curSum + array[i]);
            curSubSeq.remove(curSubSeq.size() - 1);
        }
    }
}
