package dsa.recursion.test;

public class PalindromeTest {
    /*  Test for Palindrome
     * A palindrome is a string that reads the same backward as forward.
     */

    public static void main(String[] args) {
        String input = "madam";
        boolean expectedAns = true;
        boolean actualAns = dsa.recursion.main.Palindrome.checkPalindrome(input, 0);
        if (actualAns == expectedAns) {
            System.out.println("..........TEST PASSED.............");
        } else {
            System.out.println("..........TEST FAILED.............");
        }
    }
}
