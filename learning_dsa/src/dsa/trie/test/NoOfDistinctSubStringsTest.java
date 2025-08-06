package dsa.trie.test;

import dsa.trie.main.NoOfDistinctSubStrings;

public class NoOfDistinctSubStringsTest {
    public static void main(String[] args) {
        NoOfDistinctSubStrings solution = new NoOfDistinctSubStrings();

        String[] testInputs = {
                "ababa",       // overlapping substrings
                "aaaa",        // all characters same
                "abc",         // all unique substrings
                "a",           // single character
                "",            // empty string
                "banana",      // common test case for substrings
                "ababc"        // mix of repeat and unique
        };

        for (String input : testInputs) {
            int expected = solution.getNoOfDistinctSubStringsUsingSet(input);
            int actual = solution.getNoOfDistinctSubStringsUsingTrie(input);

            System.out.println("Input: \"" + input + "\"");
            System.out.println("Expected (using Set): " + expected);
            System.out.println("Actual (using Trie): " + actual);

            if (expected == actual) {
                System.out.println("Test passed ✅");
            } else {
                System.out.println("Test failed ❌");
            }
            System.out.println("---------------------------");
        }
    }
}
