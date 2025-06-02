package dsa.array.main;

import java.util.*;

public class RemoveDuplicatesInSortedArray {

    public static void removeDupFromArrayBrut(int[] arr) {
        removeDupFromArrayBrut(arr, arr.length);
    }

    public static void removeDupFromArrayOptimal(int[] arr) {
        removeDupFromArrayOptimal(arr, arr.length);
    }

    //TC - O(N logN) + O(X)
    //SC - O(X) => X is number of unique elements
    private static void removeDupFromArrayBrut(int[] arr, int n) {
        Set<Integer> numbersSet = new HashSet<>();

        //O(N logN)
        for (int element : arr) {
            numbersSet.add(element);
        }

        //O(X)  => X is number of unique elements
        int i = 0;
        Iterator<Integer> iterator = numbersSet.iterator();
        while (iterator.hasNext()) {
            arr[i] = iterator.next();
            i++;
        }
    }

    //two pointer
    //TC - O(N)
    //SC - O(1)
    private static void removeDupFromArrayOptimal(int[] arr, int n) {
        int uniqueInd = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[uniqueInd]) {
                uniqueInd++;
                arr[uniqueInd] = arr[i];
            }
        }
    }
}
