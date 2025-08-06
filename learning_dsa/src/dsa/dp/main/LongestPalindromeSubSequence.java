package dsa.dp.main;

import static dsa.dp.main.LengthOfLongestCommonSubsequence.getLCS;

public class LongestPalindromeSubSequence {

    public static String getLCPSubSequence(String s1){
        String s2 = new StringBuilder(s1).reverse().toString();
        return getLCS(s1, s2);
    }

}
