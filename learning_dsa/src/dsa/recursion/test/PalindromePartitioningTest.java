package dsa.recursion.test;

import java.util.List;

import static dsa.recursion.main.PalindromePartitioning.getAllPalindromePartitionSusStrings;

public class PalindromePartitioningTest {
    /*
    Given a string s partition string s such that every substring of partition is palindrome. Return all possible palindrome partition of string s.
    Examples:
      Input : s = "aabaa"
      Output : [ [ "a", "a", "b", "a", "a"] , [ "a", "a", "b", "aa"] , [ "a", "aba", "a"] , [ "aa", "b", "a", "a"] , [ "aa", "b", "aa" ] , [ "aabaa" ] ]
      Explanation : Above all are the possible ways in which the string can be partitioned so that each substring is a palindrome.

      Input : s = "baa"
      Output : [ [ "b", "a", "a"] , [ "b", "aa" ] ]
     Explanation : Above all are the possible ways in which the string can be partitioned so that each substring is a palindrome.

     */

    public static void main(String[] args) {
        String input = "aabaa";

        List<List<String>> result = getAllPalindromePartitionSusStrings(input);
        for (List<String> partition : result) {
            System.out.println(partition);
        }
    }
}
