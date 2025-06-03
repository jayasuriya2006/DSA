package dsa.twopointer.test;

import dsa.twopointer.main.LongestSubstringWithAtMostKDistinctChar;

public class LongestSubstringWithAtMostKDistinctCharTest {
    public static void main(String[] args) {
//        String s="aaabacca";
//        int k=2;
//       //Expected: 5
//
//        String s = "aabacbebebe";
//        int k = 3;
//       // Expected: 7 ("cbebebe")
//
//        String s = "abc";
//        int k = 0;
//     // Expected: 0 (no characters allowed)
//
//        String s = "abcabcbb";
//        int k = 2;
//         // Expected: 4 ("bcbc" or "cabc")
//
        String s = "eceba";
        int k = 2;
        // Expected: 3 ("ece")


        System.out.println(LongestSubstringWithAtMostKDistinctChar.brute(s, k));
        System.out.println(LongestSubstringWithAtMostKDistinctChar.better(s, k));
        System.out.println(LongestSubstringWithAtMostKDistinctChar.optimal(s, k));
    }
}
