package dsa.twopointer.test;
import dsa.twopointer.main.MinimumWindowSubstring;

public class MinimumWindowSubstringTest {
    public static void main(String[] args){


//        String s = "ddaaoabbca";
//        String t = "abc";
////        Expected: "bca"
//
//        String s = "abcde";
//        String t = "abc";
//        Expected: "abc"
//
//        String s = "xyzabc";
//        String t = "abc";
//        Expected: "abc"
//
        String s = "adobecodebanc";
        String t = "abc";
//        Expected: "banc"

        System.out.println(MinimumWindowSubstring.brute(s,t));
        System.out.println(MinimumWindowSubstring.optimal(s,t));


    }
}
