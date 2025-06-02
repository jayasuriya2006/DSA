package dsa.array.main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    //TC - O(N * N) not exactly
    //SC - O(1)
    //Take each element and check for the sequence with linear search
    public static int getLongestConsecutiveSequence_Brut(int[] arr) {
        int n = arr.length;
        int maxLongCons = 1;

        for (int i = 0; i < n; i++) {
            int item = arr[i];
            int count = 1;
            while (LinearSearchInArray.getTheIndex(arr, item + 1) != -1) {
                count++;
                item = item + 1;
                maxLongCons = Math.max(count, maxLongCons);
            }
        }

        return maxLongCons;
    }

    //TC - O(N logN + N)
    //SC - O(1)
    //search for the sorted array, will be easy
    public static int getLongestConsecutiveSequence_Better(int[] arr) {
        int n = arr.length;

        int maxLongCons = 1;
        Arrays.sort(arr);
        int count = 0;

        //keep track for the last seen min value
        int lastMin = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            //if cur value min + 1 , then it's part of the sequence
            //else if cur value == min, continue
            //else reset the sequence
            if (arr[i] == lastMin + 1) {
                count = count + 1;
                lastMin = arr[i];
                maxLongCons = Math.max(count, maxLongCons);
            } else if (arr[i] == lastMin) {
                continue;
            } else {
                count = 1;
                lastMin = arr[i];
            }
        }
        return maxLongCons;
    }

    //TC - O(2N)
    //SC - O(N)
    //put all the elements in the set, accessing will be easy with O(1)
    public static int getLongestConsecutiveSequence_Optimal(int[] arr) {
        int n = arr.length;
        int maxLongCons = 1;
        Set<Integer> numberSet = new HashSet<>();
        //put all the elements into set
        for (int item : arr) {
            numberSet.add(item);
        }

        for (int i = 0; i < n; i++) {
            int item = arr[i];
            int count = 1;
            //if cur element is x and set has x - 1, then there is no meaning check the sequence with start with x. sequence start from
            //x - 1 will be the longest
            if (!numberSet.contains(arr[i] - 1)) {
                while (numberSet.contains(item + 1)) {
                    count++;
                    item = item + 1;
                }
            }
            maxLongCons = Math.max(count, maxLongCons);
        }
        return maxLongCons;
    }
}
