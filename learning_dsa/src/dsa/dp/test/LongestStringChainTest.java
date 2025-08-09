package dsa.dp.test;

import dsa.dp.main.LongestStringChain;

import java.util.Arrays;

import static dsa.dp.main.LongestStringChain.getLongestStringChainLen;

public class LongestStringChainTest {
    // Helper method to compare result and expected output
    private static void runTest(String[] input, int expected, int testNum) {
        int result = LongestStringChain.getLongestStringChainLen(input);
        if (result == expected) {
            System.out.println("Test " + testNum + " ✅ Passed: " + result);
        } else {
            System.out.println("Test " + testNum + " ❌ Failed");
            System.out.println("  Input:     " + Arrays.toString(input));
            System.out.println("  Expected:  " + expected);
            System.out.println("  Got:       " + result);
        }
    }

    public static void main(String[] args) {
        // Test 1: Basic example
        runTest(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}, 4, 1);
        // Chain: a → ba → bda → bdca

        // Test 2: Single word
        runTest(new String[]{"word"}, 1, 2);

        // Test 3: Empty input
        runTest(new String[]{}, 0, 3);

        // Test 4: Multiple chains, pick longest
        runTest(new String[]{"a", "ab", "ac", "bd", "abc", "abd", "abdd"}, 4, 4);
        // Chain: a → ab → abd → abdd

        // Test 5: No valid chains
        runTest(new String[]{"cat", "dog", "mouse"}, 1, 5);

        // Test 6: Words with varying lengths but no chain
        runTest(new String[]{"a", "abc", "ab"}, 3, 6); // a → ab

        // Test 7: Chain with skips
        runTest(new String[]{"a", "ab", "abc", "abcd", "abcde"}, 5, 7); // a → ab → abc → abcd → abcde

        // Test 8: Words with same lengths only
        runTest(new String[]{"ab", "cd", "ef"}, 1, 8);

        // Test 9: Longer input
        runTest(new String[]{"a", "b", "ba", "bca", "bd", "bdc", "bdca", "bdcab"}, 5, 9);
        // Chain: a → ba → bda → bdca → bdcab
    }
}
