package dsa.stackqueue.main;

import java.util.Stack;

public class RemoveKDigitsMakeSmall {

    public static String removeKDigitsMakeSmallNumber(String input, int k) {
        if (input.isEmpty() || k >= input.length()) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);
            //inserting a smaller number possible
            while (!stack.isEmpty() && stack.peek() - '0' > curChar - '0' && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(curChar);
        }

        //if still k left
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        if (stack.isEmpty()) return "0";

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        //removing 0s at begin
        while (!result.isEmpty() && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }
        if (result.isEmpty()) {
            return "0";
        }
        result.reverse();
        return result.toString();
    }
}
