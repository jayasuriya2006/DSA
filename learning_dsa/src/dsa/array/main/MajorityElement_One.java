package dsa.array.main;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_One {

    //Iterate each element and count the occurrences
    //TC - O(n * n)
    public static int findMajority_Brut(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > n / 2) {
                return arr[i];
            }

        }
        return -1;
    }


    //Use hashmap and count the occurrences
    //TC - O(2N) - worst case
    //SC - O(N) - worst case
    public static int findMajority_Better(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int i = 0; i < n; i++) {
            occurrences.put(arr[i], occurrences.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry entry : occurrences.entrySet()) {
            int key = (int) entry.getKey();
            int value = (int) entry.getValue();
            if (value > n / 2) {
                return key;
            }

        }
        return -1;
    }

    //use voting method
    //TC - O(N) - worst case
    //SC - O(1) - worst case
    public static int findMajority_Optimal(int[] arr) {
        int count = 0;
        int element = 0;

        // occurrence more than n/2 only one element possible
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            //till this no majority
            if (count == 0) {
                element = arr[i];
                count++;
                continue;
            }
            if (arr[i] == element) {
                count++;
            } else {
                count--;
            }
        }

        //verify the occurrence
        int freq = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == element) {
                freq++;
            }
        }
        if (freq > n / 2) {
            return element;
        }

        return -1;
    }

}
