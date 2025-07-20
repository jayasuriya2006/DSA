package dsa.recursion.main;

import java.util.ArrayList;
import java.util.List;


public class AllPermutationsTwo {

    public static List<List<Integer>> getAllPermutations(int[] arr) {
        List<List<Integer>> allPermutations = new ArrayList<>();
        getAllPermutations(0, arr, allPermutations);
        return allPermutations;
    }

    //TC - O(n! * n)
    //SC - O(n)
    private static void getAllPermutations(int index, int[] arr, List<List<Integer>> allPermutations) {

        if (index == arr.length) {
            List<Integer> curPermutation = new ArrayList<>();
            for (int item : arr) {
                curPermutation.add(item);
            }
            allPermutations.add(curPermutation);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            getAllPermutations(index + 1, arr, allPermutations);
            swap(arr, index, i);
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}



