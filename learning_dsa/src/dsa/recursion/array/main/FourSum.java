package dsa.array.main;

import java.util.*;

public class FourSum {
    //TC - O(n * n * n * n)
    //SC - O(m * 4)   m-> no of unique list
    public static List<List<Integer>> getFourSum_Brut(int[] arr, int target) {
        int n = arr.length;

        Set<List<Integer>> uniqueSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        int sum = arr[i] + arr[j] + arr[k] + arr[l];
                        if (sum == target) {
                            List<Integer> temp = new ArrayList<>(List.of(arr[i], arr[j], arr[k], arr[l]));
                            Collections.sort(temp);
                            uniqueSet.add(temp);
                        }
                    }
                }

            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.addAll(uniqueSet);
        return result;
    }

    //For 4th element check the set - set will be having elements i to j (don't store all elements in set)   i , j fixed.. j to k in set
    //TC - O(n * n * n)
    //SC - O(m * 4)   m-> no of unique list
    public static List<List<Integer>> getFourSum_Better(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> uniqueSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            // if(i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                Set<Integer> curItems = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int wanted = target - (arr[i] + arr[j] + arr[k]);
                    if (curItems.contains(wanted)) {
                        List<Integer> temp = new ArrayList<>(List.of(arr[i], arr[j], arr[k], wanted));
                        Collections.sort(temp);
                        uniqueSet.add(temp);
                    }
                    curItems.add(arr[k]);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(uniqueSet);
        return result;
    }

    //fix two point and move the two pints in sorted array
    //TC - O(n * n * n) + O (n logn)
    //SC - O(1)
    public static List<List<Integer>> getFourSum_Optimal(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && arr[j] == arr[j - 1]) continue;
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum == target) {
                        List<Integer> temp = List.of(arr[i], arr[j], arr[k], arr[l]);
                        result.add(temp);
                        k++;
                        l--;
                        //for avoiding duplicates, since sorted
                        while (k < l && arr[k] == arr[k - 1]) k++;
                        while (k < l && arr[l] == arr[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return result;
    }
}
