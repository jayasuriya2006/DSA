package dsa.array.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {

    //TC - O(N * N)
    //SC - O(1)
    public static List<Integer> getMajorityElement_Brut(int[] arr) {
        int n = arr.length;
        int needsCount = (n / 3);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > needsCount) {
                //we know only two elements possible to occur > n / 3
                if (result.isEmpty() || result.getLast() != arr[i]) {
                    result.add(arr[i]);
                    if (result.size() == 2) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    //TC - O(N)
    //SC - O(N)
    public static List<Integer> getMajorityElement_Better(int[] arr) {
        int n = arr.length;
        int needsCount = (n / 3);
        List<Integer> result = new ArrayList<>();

        //arr[i] -> frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int freq = freqMap.getOrDefault(arr[i], 0);
            //current count +1
            if (freq + 1 == needsCount + 1) {
                result.add(arr[i]);
                if (result.size() == 2) {
                    return result;
                }
            }
            freqMap.put(arr[i], freq + 1);
        }

        return result;
    }

    //TC - O(2N)
    //sc - O(1)
    //algorithms derived based on 1st version of problem
    public static List<Integer> getMajorityElement_Optimal(int[] arr) {
        int n = arr.length;
        int needsCount = (n / 3);
        List<Integer> result = new ArrayList<>();

        int element1 = 0;
        int element2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && arr[i] != element2) {
                count1 = 1;
                element1 = arr[i];
            } else if (count2 == 0 && arr[i] != element1) {
                count2 = 1;
                element2 = arr[i];
            } else if (element1 == arr[i]) {
                count1++;
            } else if (element2 == arr[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        int freq1 = 0, freq2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == element1) freq1++;
            if (arr[i] == element2) freq2++;
        }

        if (freq1 > needsCount) result.add(element1);
        if (freq2 > needsCount) result.add(element2);

        return result;
    }

}
