package dsa.dp.test;

import dsa.dp.main.RodCutting;

public class RodCuttingTest {
    public static void main(String[] args) {
        runTest(new int[]{2, 5, 7, 8}, 11, "Basic Test");
        runTest(new int[]{1, 5, 8, 9, 10, 17, 17, 20}, 22, "Classic Problem");
        runTest(new int[]{3, 5, 8, 9, 10, 17, 17, 20}, 24, "Increased Base Value");
        runTest(new int[]{5, 5, 5, 5, 5, 5, 5, 5}, 40, "All Prices Same");
        runTest(new int[]{1}, 1, "Single Length Rod");
        runTest(new int[]{5}, 5, "Only One Way to Cut");
        runTest(new int[]{2, 5, 7, 3, 8}, 12, "Random Values");
        runTest(new int[]{3, 5, 1, 2}, 10, "Low Profit for Some Cuts");
        runTest(new int[]{2, 5, 7, 8, 10, 17, 20, 24, 30}, 37, "Longer Rod");
    }

    private static void runTest(int[] prices, int expected, String description) {
        int rec = RodCutting.getMaxProfitFromRod_Recursion(prices);
        int memo = RodCutting.getMaxProfitFromRod_Memo(prices);
        int tab = RodCutting.getMaxProfitFromRod_Tabulation(prices);
        int spaceOpt = RodCutting.getMaxProfitFromRod_SpaceOptimized(prices);

        System.out.println("\n=== " + description + " ===");
        System.out.println("Recursion: " + rec);
        System.out.println("Memoization: " + memo);
        System.out.println("Tabulation: " + tab);
        System.out.println("Space Optimized: " + spaceOpt);

        if (rec == memo && memo == tab && tab == spaceOpt) {
            System.out.println("✅ All methods returned: " + rec);
        } else {
            System.out.println("❌ Mismatch in outputs!");
        }
    }
}
