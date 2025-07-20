package dsa.recursion.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubSeqNoDuplicate {
    public static List<List<Integer>> getAllSubSeqNoDuplicates(int[] array) {
        List<List<Integer>> allSubSeq = new ArrayList<>();
        Arrays.sort(array);
        getAllSubSeqWithKSumNoDuplicates(0, array, allSubSeq, new ArrayList<>());
        return allSubSeq;
    }

    private static void getAllSubSeqWithKSumNoDuplicates(int index, int[] array, List<List<Integer>> allSubSeq, List<Integer> curSubSeq) {

        allSubSeq.add(new ArrayList<>(curSubSeq));

        for (int i = index; i < array.length; i++) {
            //avoid duplicate
            if (i != index && array[i] == array[i - 1]) {
                continue;
            }

            curSubSeq.add(array[i]);
            getAllSubSeqWithKSumNoDuplicates(i + 1, array, allSubSeq, curSubSeq);
            curSubSeq.remove(curSubSeq.size() - 1);
        }
    }
}
