package dsa.stackqueue.main;

import java.util.Stack;

public class ExpressionConverter {

    public static String infixToPostfixConversion(String infix) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int n = infix.length();
        int i = 0;
        while (i < n) {
            char curChar = infix.charAt(i);
            if (Character.isLetterOrDigit(curChar)) {
                ans.append(curChar);
                i++;
            } else if (curChar == '(') {
                stack.push(curChar);
                i++;
            } else if (curChar == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans.append(stack.pop());
                }
                stack.pop();    //remove (
                i++;
            } else {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(curChar)) {
                    ans.append(stack.pop());
                }
                stack.push(curChar);
                i++;
            }
        }

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.toString();
    }

    public static String infixToPrefixConversion(String infix) {
        //reverse
        infix = new StringBuilder(infix).reverse().toString();

        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int n = infix.length();
        int i = 0;
        while (i < n) {
            char curChar = infix.charAt(i);
            if (Character.isLetterOrDigit(curChar)) {
                ans.append(curChar);
                i++;
            } else if (curChar == ')') {
                stack.push(curChar);
                i++;
            } else if (curChar == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    ans.append(stack.pop());
                }
                stack.pop();    //remove (
                i++;
            } else {
                if (curChar == '^') {
                    while (!stack.isEmpty() && priority(curChar) <= priority(stack.peek())) {
                        ans.append(stack.pop());
                    }
                }
                while (!stack.isEmpty() && priority(stack.peek()) > priority(curChar)) {
                    ans.append(stack.pop());
                }
                stack.push(curChar);
                i++;
            }
        }

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        //reverse the answer
        ans.reverse();
        return ans.toString();
    }


    public static String postfixToInfixConversion(String postfix) {
        Stack<String> stack = new Stack<>();
        int n = postfix.length();
        int i = 0;
        while (i < n) {
            char curChar = postfix.charAt(i);
            if (Character.isLetterOrDigit(curChar)) {
                stack.push(String.valueOf(curChar));
                i++;
            } else {
                String top1 = stack.pop();
                String top2 = stack.pop();
                String exp = "(" + top2 + curChar + top1 + ")";
                stack.push(exp);
                i++;
            }
        }
        return stack.pop();
    }

    public static String prefixToInfixConversion(String prefix) {

        Stack<String> stack = new Stack<>();
        int n = prefix.length();
        int i = n - 1;
        while (i >= 0) {
            char curChar = prefix.charAt(i);
            if (Character.isLetterOrDigit(curChar)) {
                stack.push(String.valueOf(curChar));
                i--;
            } else {
                String top1 = stack.pop();
                String top2 = stack.pop();
                String exp = "(" + top1 + curChar + top2 + ")";
                stack.push(exp);
                i--;
            }
        }
        return stack.pop();
    }

    public static String postfixToPrefixConversion(String postfix) {

        Stack<String> stack = new Stack<>();
        int n = postfix.length();
        int i = 0;
        while (i < n) {
            char curChar = postfix.charAt(i);
            if (Character.isLetterOrDigit(curChar)) {
                stack.push(String.valueOf(curChar));
                i++;
            } else {
                String top1 = stack.pop();
                String top2 = stack.pop();
                String exp = curChar + top2 + top1;
                stack.push(exp);
                i++;
            }
        }
        return stack.pop();
    }

    public static String prefixToPostfixConversion(String prefix) {

        Stack<String> stack = new Stack<>();
        int n = prefix.length();
        int i = n - 1;
        while (i >= 0) {
            char curChar = prefix.charAt(i);
            if (Character.isLetterOrDigit(curChar)) {
                stack.push(String.valueOf(curChar));
                i--;
            } else {
                String top1 = stack.pop();
                String top2 = stack.pop();
                String exp = top1 + top2 + curChar;
                stack.push(exp);
                i--;
            }
        }
        return stack.pop();
    }

    private static int priority(char curChar) {
        return switch (curChar) {
            case '^' -> 3;
            case '*' -> 2;
            case '/' -> 2;
            case '+' -> 1;
            case '-' -> 1;
            default -> -1;
        };
    }
}
