package dsa.twopointer.test;

import dsa.twopointer.main.LongestRepeatingCharacterReplacement;

public class LongestRepeatingCharacterReplacementTest {
    public static void main(String[] args) {
//        String s = "AAABABCA";
//        int k = 2;

//        String s = "AAAA";
//        int k = 2;
// Output: 4 → All characters are already the same, no need to replace.

        String s = "ABAB";
        int k = 2;
// Output: 4 → Replace two B's or two A's → "AAAA" or "BBBB".
//
//        String s = "AABABBA";
//        int k = 1;
// Output: 4 → "ABBA" → replace one B to A or vice versa.

//        String s = "AABCCCDDD";
//        int k = 2;
// Output: 6 → Replace two Cs to D → "CCCDDD" → longest = 6.

//        String s = "ABCDE";
//        int k = 0;
//// Output: 1 → No replacements allowed, max single letter window is 1.

        System.out.println(LongestRepeatingCharacterReplacement.brute(s, k));
        System.out.println(LongestRepeatingCharacterReplacement.better(s,k));
        System.out.println(LongestRepeatingCharacterReplacement.optimal(s,k));

    }
}
