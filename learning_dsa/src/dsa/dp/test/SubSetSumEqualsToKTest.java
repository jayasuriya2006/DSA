package dsa.dp.test;

import dsa.dp.main.SubSetSumEqualsToK;

public class SubSetSumEqualsToKTest {
    public static void main(String[] args) {
        testEqualPartition();
        testSubsetSum();
        testMinAbsDiff();
    }

    private static void testEqualPartition() {
        System.out.println("=== Testing Equal Partition ===");
        int[] arr1 = {1, 5, 11, 5};
        System.out.println(SubSetSumEqualsToK.canSplitIntoTwoSubSetsWithEqualSum(arr1)); // true

        int[] arr2 = {1, 2, 3, 5};
        System.out.println(SubSetSumEqualsToK.canSplitIntoTwoSubSetsWithEqualSum(arr2)); // false

        int[] arr3 = {3, 1, 1, 2, 2, 1};
        System.out.println(SubSetSumEqualsToK.canSplitIntoTwoSubSetsWithEqualSum(arr3)); // true
    }

    private static void testSubsetSum() {
        System.out.println("=== Testing Subset Sum ===");
        int[] arr = {2, 3, 7, 8, 10};

        System.out.println(SubSetSumEqualsToK.isArrayHasSubSetWhichSumIsK_Recursion(arr, 11)); // true
        System.out.println(SubSetSumEqualsToK.isArrayHasSubSetWhichSumIsK_Memo(arr, 14)); // false
        System.out.println(SubSetSumEqualsToK.isArrayHasSubSetWhichSumIsK_Tabulation(arr, 9)); // true
        System.out.println(SubSetSumEqualsToK.isArrayHasSubSetWhichSumIsK_SpaceOptimized(arr, 30)); // true
    }

    private static void testMinAbsDiff() {
        System.out.println("=== Testing Min Abs Diff ===");
        int[] arr1 = {1, 2, 3, 9};
        System.out.println(SubSetSumEqualsToK.getMinAbsDiffBetweenTwoSubSets(arr1)); // 3

        int[] arr2 = {1, 2, 7};
        System.out.println(SubSetSumEqualsToK.getMinAbsDiffBetweenTwoSubSets(arr2)); // 4

        int[] arr3 = {3, 1, 4, 2, 2, 1};
        System.out.println(SubSetSumEqualsToK.getMinAbsDiffBetweenTwoSubSets(arr3)); // 1
    }
}
