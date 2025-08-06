package dsa.dp.test;

import dsa.dp.main.NoOfWaysToFormTarget;

public class NoOfWaysToFormTargetTest {
    public static void main(String[] args) {

        // Test 1: Basic case
        int[] coins1 = {1, 2, 5};
        int target1 = 5;
        System.out.println("=== Test 1: Basic ===");
        runTest(coins1, target1, 4);

        // Test 2: No solution
        int[] coins2 = {2};
        int target2 = 3;
        System.out.println("\n=== Test 2: No Solution ===");
        runTest(coins2, target2, 0);

        // Test 3: Zero target
        int[] coins3 = {1};
        int target3 = 0;
        System.out.println("\n=== Test 3: Zero Target ===");
        runTest(coins3, target3, 1);

        // Test 4: Multiple coins with small target
        int[] coins4 = {1, 2, 3};
        int target4 = 4;
        System.out.println("\n=== Test 4: Multiple Ways ===");
        runTest(coins4, target4, 4);

        // Test 5: All coin values greater than target
        int[] coins5 = {5, 6, 7};
        int target5 = 3;
        System.out.println("\n=== Test 5: No Ways (All coins > target) ===");
        runTest(coins5, target5, 0);

        // Test 6: Repeating coin denominations
        int[] coins6 = {1, 1, 2};
        int target6 = 3;
        System.out.println("\n=== Test 6: Repeating Coins ===");
        runTest(coins6, target6, 6);

        // Test 7: Single coin equals target
        int[] coins7 = {3};
        int target7 = 3;
        System.out.println("\n=== Test 7: Single Coin Match ===");
        runTest(coins7, target7, 1);

        // Test 8: Large target small coins
        int[] coins8 = {1, 2};
        int target8 = 10;
        System.out.println("\n=== Test 8: Larger Target ===");
        runTest(coins8, target8, 6);

        // Test 9: Duplicated coin values but different positions
        int[] coins9 = {1, 2, 2, 3};
        int target9 = 5;
        System.out.println("\n=== Test 9: Duplicated Denominations ===");
        runTest(coins9, target9, 9);

        // Test 10: Only one way to make target
        int[] coins10 = {2, 3, 7};
        int target10 = 7;
        System.out.println("\n=== Test 10: Only One Way ===");
        runTest(coins10, target10, 2);
    }

    private static void runTest(int[] coins, int target, int expected) {
        System.out.println("Expected: " + expected);
        System.out.println("Recursion: " + NoOfWaysToFormTarget.noOfWaysToFormATarget_Recursion(coins, target));
        System.out.println("Memoization: " + NoOfWaysToFormTarget.noOfWaysToFormATarget_Memo(coins, target));
        System.out.println("Tabulation: " + NoOfWaysToFormTarget.noOfWaysToFormATarget_Tabulation(coins, target));
        System.out.println("Space Optimized: " + NoOfWaysToFormTarget.noOfWaysToFormATarget_SpaceOptimized(coins, target));
    }
}
