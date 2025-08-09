package dsa.dp.main;

public class NoOfLIS {

    public static int getNoOfLis(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] dp1 = new int[n];
        int[] count = new int[n];
        dp1[0] = 1;
        count[0] = 1;
        int maxi = 1;
        for (int ind = 1; ind < n; ind++) {
            dp1[ind] = 1;
            count[ind] = 1;
            for (int prevInd = 0; prevInd < ind; prevInd++) {
                if (nums[ind] > nums[prevInd]) {
                    if (dp1[ind] < dp1[prevInd] + 1) {
                        dp1[ind] = dp1[prevInd] + 1;
                        count[ind] = count[prevInd];
                        maxi = Math.max(maxi, dp1[ind]);
                    } else if (dp1[ind] == dp1[prevInd] + 1) {
                        count[ind] = count[ind] + count[prevInd];
                    }
                }
            }
        }
        int noOfLIS = 0;
        for (int i = 0; i < n; i++) {
            if (dp1[i] == maxi) noOfLIS += count[i];
        }
        return noOfLIS;
    }
}
