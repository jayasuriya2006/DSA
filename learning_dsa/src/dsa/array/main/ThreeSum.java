package dsa.array.main;

import java.util.*;

public class ThreeSum {

    //TC - O(n * n * n)
    //SC - O(m * 3)   m-> no of unique list
    public static List<List<Integer>> getThreeSum_Brut(int[] arr, int target) {
        int n = arr.length;

        Set<List<Integer>> uniqueSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>(List.of(arr[i], arr[j], arr[k]));
                        Collections.sort(temp);
                        uniqueSet.add(temp);
                    }
                }

            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.addAll(uniqueSet);
        return result;
    }

    //For 3rd element check the set - set will be having elements i to j (don't store all elements in set)
    //TC - O(n * n)
    //SC - O(m * 3)   m-> no of unique list
    public static List<List<Integer>> getThreeSum_Better(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> uniqueSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            // if(i > 0 && arr[i] == arr[i - 1]) continue;
            Set<Integer> curItems = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int wanted = target - (arr[i] + arr[j]);
                if (curItems.contains(wanted)) {
                    List<Integer> temp = new ArrayList<>(List.of(arr[i], arr[j], wanted));
                    Collections.sort(temp);
                    uniqueSet.add(temp);
                }
                curItems.add(arr[j]);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(uniqueSet);
        return result;
    }

    //fix one point and move the two pints in sorted array
    //TC - O(n * n) + O (n logn)
    //SC - O(1)
    public static List<List<Integer>> getThreeSum_Optimal(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == target) {
                    List<Integer> temp = List.of(arr[i], arr[j], arr[k]);
                    result.add(temp);
                    j++;
                    k--;
                    //for avoiding duplicates, since sorted
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}
