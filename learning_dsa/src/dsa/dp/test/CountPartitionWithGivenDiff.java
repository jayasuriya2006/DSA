package dsa.dp.test;

import static dsa.dp.main.CountPartitionWithGivenDiff.countPartitionWithWithGivenDiff;

public class CountPartitionWithGivenDiff {
    public static void main(String[] args) {
        // === Test 1: Basic case ===
        int[] arr1 = {1, 1, 2, 3};
        int diff1 = 1;
        int result1 = countPartitionWithWithGivenDiff(arr1, diff1);
        System.out.println("=== Test 1: Basic Case ===");
        System.out.println("Expected: 3, Got: " + result1);  // Expected: 3

        // === Test 2: No valid partition due to (sum - diff) being odd ===
        int[] arr2 = {1, 2, 3};
        int diff2 = 1;
        int result2 = countPartitionWithWithGivenDiff(arr2, diff2);
        System.out.println("\n=== Test 2: Invalid due to odd sum-diff ===");
        System.out.println("Expected: 0, Got: " + result2);  // Expected: 0

        // === Test 3: All elements are zero ===
        int[] arr3 = {0, 0, 0, 0};
        int diff3 = 0;
        int result3 = countPartitionWithWithGivenDiff(arr3, diff3);
        System.out.println("\n=== Test 3: All Zeros ===");
        System.out.println("Expected: 16, Got: " + result3);  // 2^4 = 16 valid partitions

        // === Test 4: Negative diff or not possible ===
        int[] arr4 = {1, 2, 7};
        int diff4 = 10;
        int result4 = countPartitionWithWithGivenDiff(arr4, diff4);
        System.out.println("\n=== Test 4: No Valid Partition (diff too large) ===");
        System.out.println("Expected: 0, Got: " + result4);

        // === Test 5: Larger input ===
        int[] arr5 = {5, 2, 6, 4};
        int diff5 = 3;
        int result5 = countPartitionWithWithGivenDiff(arr5, diff5);
        System.out.println("\n=== Test 5: Larger Array ===");
        System.out.println("Expected: 1, Got: " + result5);

        // === Test 6: Single Element ===
        int[] arr6 = {3};
        int diff6 = 3;
        int result6 = countPartitionWithWithGivenDiff(arr6, diff6);
        System.out.println("\n=== Test 6: Single Element ===");
        System.out.println("Expected: 1, Got: " + result6);  // {3}, {} is a valid split
    }
}
