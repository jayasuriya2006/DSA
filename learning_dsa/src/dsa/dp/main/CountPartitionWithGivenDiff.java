package dsa.dp.main;

public class CountPartitionWithGivenDiff {

    public static int countPartitionWithWithGivenDiff(int[] arr, int diff) {
        int sum = 0;
        for (int ele : arr) {
            sum += ele;
        }

        //S1 + S2 = TotalSum
        //S1 = TotalSum - S2

        // => S1 - S2 = D
        // TotalSum - S2 - S2 = D
        // 2S2 = TotalSum - D
        // S2 = (TotalSum - D) / 2;

        if ((sum - diff) < 0 || (sum - diff) % 2 == 1) return 0;
        CountSubsetsWithSumK solver = new CountSubsetsWithSumK();
        return solver.countSubsetWithSumAsK_SpaceOptimized(arr, (sum - diff) / 2);
    }


}
