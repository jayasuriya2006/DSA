package dsa.twopointer.test;

import dsa.twopointer.main.LongSubstringWithoutRepeatingChar;

public class LongSubstringWithoutRepeatingCharTest {
    /*
    find the length of the longest substring without duplicate characters.

     Example :
     Input: s = "abcabcbb"
     Output: 3
     Explanation: The answer is "abc", with the length of 3.

     */


    public static void main(String[] args) {
//         String s="abcdfaugaz";
//         output:7


//        String s = "bbbbb";
//        Output: 1


//        String s = "pwwkew";
//        Output: 3


        String s = "abcdef";
//      Output: 6

        System.out.println(LongSubstringWithoutRepeatingChar.brute(s) + " Brut");
        System.out.println(LongSubstringWithoutRepeatingChar.optimal(s) + " Optimal");
    }
}
