package dsa.dp.main;

public class LongestBitonicSubsequence {

    public static int longestBitonicSubSequence(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = 1;
        dp2[n - 1] = 1;
        for (int ind = 1; ind < n; ind++) {
            dp1[ind] = 1;
            for (int prevInd = 0; prevInd < ind; prevInd++) {
                if (nums[ind] > nums[prevInd]) {
                    if (dp1[ind] < dp1[prevInd] + 1) {
                        dp1[ind] = dp1[prevInd] + 1;
                    }
                }
            }
        }

        int maxi = dp1[n - 1];
        for (int ind = n - 2; ind >= 0; ind--) {
            dp2[ind] = 1;
            for (int prevInd = n - 1; prevInd > ind; prevInd--) {
                if (nums[ind] > nums[prevInd]) {
                    if (dp2[ind] < dp2[prevInd] + 1) {
                        dp2[ind] = dp2[prevInd] + 1;
                    }
                }
            }
            maxi = Math.max(maxi, dp1[ind] + dp2[ind] - 1);
        }
        return maxi;
    }

}
