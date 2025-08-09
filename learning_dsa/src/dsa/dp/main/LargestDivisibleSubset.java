package dsa.dp.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {

    //TC - O(NlogN) + O(N * N) + O(N)
    //SC - O(N * N)
    public static List<Integer> getDivisibleSubset_OptimalWay(int[] numbers) {
        int n = numbers.length;
        if (n == 0) return new ArrayList<>();
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(numbers);
        int lis = 1;
        int lisEndInd = 0;
        for (int ind = 0; ind < n; ind++) {
            hash[ind] = ind;
            for (int prevInd = 0; prevInd < ind; prevInd++) {
                if (numbers[ind] % numbers[prevInd] == 0) {
                    if (dp[ind] < dp[prevInd] + 1) {
                        dp[ind] = dp[prevInd] + 1;
                        hash[ind] = prevInd;
                        if (lis < dp[ind]) {
                            lis = dp[ind];
                            lisEndInd = ind;
                        }
                    }
                }
            }

        }
        List<Integer> lisList = new ArrayList<>();
        while (hash[lisEndInd] != lisEndInd) {
            lisList.add(numbers[lisEndInd]);
            lisEndInd = hash[lisEndInd];
        }
        lisList.add(numbers[lisEndInd]);
        Collections.reverse(lisList);
        return lisList;
    }
}
