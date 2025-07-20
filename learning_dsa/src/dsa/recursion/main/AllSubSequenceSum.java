package dsa.recursion.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllSubSequenceSum {

    public static List<Integer> getAllSubSeqSum(int[] array) {
        List<Integer> answer = new ArrayList<>();
        getAllSubSeqSum(array, 0, 0, answer);
        Collections.sort(answer);
        return answer;
    }

    private static void getAllSubSeqSum(int[] array, int index, int curSum, List<Integer> answer) {
        if (index == array.length) {
            answer.add(curSum);
            return;
        }

        //include
        getAllSubSeqSum(array, index + 1, curSum + array[index], answer);

        //not-include
        getAllSubSeqSum(array, index + 1, curSum, answer);
    }
}
