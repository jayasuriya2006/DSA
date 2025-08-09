package dsa.dp.test;

import dsa.dp.main.BurstBalloons;

import java.util.Arrays;

public class BurstBalloonsTest {
    public static void main(String[] args) {
        runTest(new int[]{3, 1, 5, 8}, 167);
        runTest(new int[]{1, 5}, 10);
        runTest(new int[]{1}, 1);
        runTest(new int[]{9, 76, 64, 21}, 116718);
        runTest(new int[]{1, 2, 3, 4, 5}, 110);
        runTest(new int[]{7, 9, 8, 0, 7, 1, 3, 5, 5, 2, 3}, 1654);
        runTest(new int[]{1, 2, 3}, 12); // (1*2*3 + 1*3*1) = 6 + 3 + 3 = 12
        runTest(new int[]{}, 0); // Empty input
    }

    private static void runTest(int[] nums, int expected) {
        System.out.println("Balloons: " + Arrays.toString(nums));

        int recResult = BurstBalloons.getMaxPointsByBurstBalloons_Recursion(nums);
        System.out.println("Recursion Result     : " + recResult);

        int memoResult = BurstBalloons.getMaxPointsByBurstBalloons_Memorization(nums);
        System.out.println("Memoization Result   : " + memoResult);

        int tabResult = BurstBalloons.getMaxPointsByBurstBalloons_Tabulation(nums);
        System.out.println("Tabulation Result    : " + tabResult);

        System.out.println("Expected Result      : " + expected);
        boolean passed = recResult == expected && memoResult == expected && tabResult == expected;
        System.out.println(passed ? "✅ Test Passed" : "❌ Test Failed");
        System.out.println("--------------------------------------------------");
    }
}
