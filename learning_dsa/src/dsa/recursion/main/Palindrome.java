package dsa.recursion.main;

public class Palindrome {

    public static boolean checkPalindrome(String input, int i) {
        //base condition
        if (i >= input.length() / 2) {
            return true;
        }

        //palindrome check
        if (input.charAt(i) != input.charAt((input.length() - i - 1))) {
            return false;
        }

        //recursive call
        return checkPalindrome(input, i + 1);
    }
}
