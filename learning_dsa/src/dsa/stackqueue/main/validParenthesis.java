package dsa.stackqueue.main;

import java.util.Stack;

public class validParenthesis {

    public static boolean isValidParenthesis(String exp) {
        int len = exp.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char curChar = exp.charAt(i);
            if (curChar == '(' || curChar == '{' || curChar == '[' || curChar == '<') {
                stack.push(curChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();

                if ((curChar == '>' && top == '<') || (curChar == '}' && top == '{') ||
                        (curChar == ']' && top == '[') || (curChar == ')' && top == '(')) {
                    continue;

                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
