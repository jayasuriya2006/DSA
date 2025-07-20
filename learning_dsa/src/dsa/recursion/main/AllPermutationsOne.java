package dsa.recursion.main;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsOne {

    public static List<List<Integer>> getAllPermutations(int[] arr) {
        List<List<Integer>> allPermutations = new ArrayList<>();
        getAllPermutations(0, arr, allPermutations, new ArrayList<>(), new boolean[arr.length]);
        return allPermutations;
    }

    //TC - O(n!)
    //SC - O(n * (n + n ))
    private static void getAllPermutations(int index, int[] arr, List<List<Integer>> allPermutations, List<Integer> curCombo, boolean[] tracker) {

        if (curCombo.size() == arr.length) {
            allPermutations.add(new ArrayList<>(curCombo));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (tracker[i] == false) {
                tracker[i] = true;
                curCombo.add(arr[i]);
                getAllPermutations(index + 1, arr, allPermutations, curCombo, tracker);

                curCombo.remove(curCombo.size() - 1);
                tracker[i] = false;

            }
        }
    }

}
