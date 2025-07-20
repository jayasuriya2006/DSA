package dsa.recursion.main;

import java.util.ArrayList;
import java.util.List;

public class AllSubSequences {

    public static List<List<Integer>> getAllSubSequences(int[] array) {
        List<List<Integer>> subsequences = new ArrayList<>();
        getSubSequences(0, array, subsequences, new ArrayList<>());
        return subsequences;

    }

    private static void getSubSequences(int i, int[] array, List<List<Integer>> subsequences, List<Integer> curSubSeq) {

        //base condition
        if (i == array.length) {
            subsequences.add(new ArrayList<>(curSubSeq));
            return;
        }

        //include case
        curSubSeq.add(array[i]);
        getSubSequences(i + 1, array, subsequences, curSubSeq);


        //not include case
        curSubSeq.removeLast();
        getSubSequences(i + 1, array, subsequences, curSubSeq);
    }
}
