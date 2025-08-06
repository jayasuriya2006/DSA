package dsa.trie.test;

import dsa.trie.main.LongestCompleteString;

public class LongestCompleteStringTest {

    public static void main(String[] args) {
        LongestCompleteString solver = new LongestCompleteString();

        String[] words1 = {"n", "ni", "nin", "ninj", "ninja", "ninjab", "ninjac", "a", "ap", "app", "appl", "apple"};
        System.out.println("Test 1: " + (solver.getLongestCommonString(words1).equals("ninjab") ? "PASS" : "FAIL"));  // ninja

        String[] words2 = {"a", "ar", "art", "arti", "artic", "articl", "article"};
        System.out.println("Test 2: " + (solver.getLongestCommonString(words2).equals("article") ? "PASS" : "FAIL"));  // article

        String[] words3 = {"a", "ab", "abc", "abcd", "abce"};
        System.out.println("Test 3: " + (solver.getLongestCommonString(words3).equals("abcd") ? "PASS" : "FAIL"));  // abcd (abcd < abce)

        String[] words4 = {"a", "b", "ba"};
        System.out.println("Test 4: " + (solver.getLongestCommonString(words4).equals("ba") ? "PASS" : "FAIL"));  // a

        String[] words5 = {"abc", "abcd", "abcde"};
        System.out.println("Test 5: " + (solver.getLongestCommonString(words5).equals("") ? "PASS" : "FAIL"));  // no complete string

    }
}
