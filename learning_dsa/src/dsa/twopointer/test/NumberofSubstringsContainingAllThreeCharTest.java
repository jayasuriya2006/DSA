package dsa.twopointer.test;

import dsa.twopointer.main.NumberofSubstringsContainingAllThreeChar;

public class NumberofSubstringsContainingAllThreeCharTest {
    /*
    Given a string consisting only of characters a, b and c.
    Return the number of substrings containing at least one occurrence of all these characters a, b and c.

    Example :
    Input: s = "abcabc"
    Output: 10
    Explanation: The substrings containing at least one occurrence of the characters a, b and c are
     "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc"
     */

    public static void main(String[] args) {
        String s = "abcabc";
//        output:10

//        String s = "abcabc";
//        output:10

//       String s = "aaacb";
//        output:3

//        String s = "aaaa";
//        output:0

        System.out.println(NumberofSubstringsContainingAllThreeChar.brute(s));
        System.out.println(NumberofSubstringsContainingAllThreeChar.better_1(s));
        System.out.println(NumberofSubstringsContainingAllThreeChar.better_2(s));
        System.out.println(NumberofSubstringsContainingAllThreeChar.optimal(s));
    }
}
